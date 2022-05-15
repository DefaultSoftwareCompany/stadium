package com.dsc.stadium.service;

import com.dsc.stadium.domain.Stadium;
import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.filter.SearchFilter;
import com.dsc.stadium.mapper.StadiumMapper;
import com.dsc.stadium.repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public StadiumDto save(StadiumDto stadiumDto) throws BadRequestException {
        if (stadiumDto.getId() != null) {
            throw new BadRequestException("New entity can't have an id!");
        }
        Stadium stadium = stadiumMapper.toEntity(stadiumDto);
        return stadiumMapper.toDto(stadiumRepository.save(stadium));
    }

    public StadiumDto update(StadiumDto stadiumDto) throws BadRequestException {
        if (stadiumDto.getId() == null) {
            throw new BadRequestException("Stadium id can't be null!");
        }
        Stadium stadium = stadiumMapper.toEntity(stadiumDto);
        return stadiumMapper.toDto(stadiumRepository.save(stadium));
    }

    public Integer delete(Integer stadiumId) {
        stadiumRepository.deleteById(stadiumId);
        return stadiumId;
    }

    public List<StadiumDto> getList(Double latitude, Double longitude) {
        return stadiumRepository.getList(latitude, longitude);
    }

    public List<StadiumDto> search(SearchFilter filter) {
        return stadiumRepository.findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAddressContainingIgnoreCase(filter.getName(), filter.getDescription(), filter.getAddress(), filter.getPageable()).map(stadiumMapper::toDto).stream().collect(Collectors.toList());
    }
}
