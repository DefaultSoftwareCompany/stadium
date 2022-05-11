package com.dsc.stadium.controller;

import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.service.StadiumService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/stadium/v1")
@SecurityRequirement(name = "bearerAuth")
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping
    public StadiumDto save(@Valid StadiumDto stadiumDto) throws BadRequestException {
        return stadiumService.save(stadiumDto);
    }

    @PutMapping
    public StadiumDto update(StadiumDto stadiumDto) throws BadRequestException {
        return stadiumService.update(stadiumDto);
    }
}