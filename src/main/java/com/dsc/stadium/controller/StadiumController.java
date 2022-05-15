package com.dsc.stadium.controller;

import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.filter.SearchFilter;
import com.dsc.stadium.service.StadiumService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public StadiumDto update(@Valid StadiumDto stadiumDto) throws BadRequestException {
        return stadiumService.update(stadiumDto);
    }

    @GetMapping
    public List<StadiumDto> getList(Double latitude, Double longitude) {
        return stadiumService.getList(latitude, longitude);
    }

    @GetMapping("search")
    public List<StadiumDto> search(SearchFilter filter) {
        return stadiumService.search(filter);
    }
}