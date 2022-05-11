package com.dsc.stadium.service;

import com.dsc.stadium.domain.Authority;
import com.dsc.stadium.domain.User;
import com.dsc.stadium.dto.UserDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.mapper.UserMapper;
import com.dsc.stadium.repository.StadiumRepository;
import com.dsc.stadium.repository.UserRepository;
import com.dsc.stadium.utils.AuthorityConstants;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StadiumRepository stadiumRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, StadiumRepository stadiumRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.stadiumRepository = stadiumRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto save(UserDto userDto) throws BadRequestException {
        if (userDto.getId() != null) {
            throw new BadRequestException("New user can't have an id");
        }
        if (userRepository.findByPhoneNumberEqualsOrLoginEquals(userDto.getPhoneNumber(), userDto.getLogin()).isPresent()) {
            throw new BadRequestException("Phone number or login has already used!");
        }
        User user = userMapper.toEntity(userDto);
        if (CollectionUtils.isEmpty(userDto.getAuthorities())) {
            Authority authority = new Authority();
            authority.setAuthority(AuthorityConstants.USER);
            user.setAuthorities(new HashSet<>(Collections.singleton(authority)));
        } else {
            user.setAuthorities(userDto.getAuthorities().stream()
                    .map(authorityConstants -> {
                        Authority authority = new Authority();
                        authority.setAuthority(authorityConstants);
                        return authority;
                    }).collect(Collectors.toSet()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto update(UserDto userDto) throws BadRequestException {
        if (userDto.getId() == null) {
            throw new BadRequestException("UserId can't be null!");
        }
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public Integer delete(Integer userId) {
        stadiumRepository.deleteAllByOwner_Id(userId);
        userRepository.deleteById(userId);
        return userId;
    }
}
