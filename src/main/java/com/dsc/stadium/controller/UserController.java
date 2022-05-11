package com.dsc.stadium.controller;

import com.dsc.stadium.dto.UserDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/v1")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto save(@Valid UserDto userDto) throws BadRequestException {
        return userService.save(userDto);
    }

    @PutMapping
    public UserDto update(UserDto userDto) throws BadRequestException {
        return userService.update(userDto);
    }

    @DeleteMapping
    public Integer delete(Integer userId) {
        return userService.delete(userId);
    }
}
