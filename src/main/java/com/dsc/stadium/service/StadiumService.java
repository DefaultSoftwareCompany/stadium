package com.dsc.stadium.service;

import com.dsc.stadium.domain.Stadium;
import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.mapper.StadiumMapper;
import com.dsc.stadium.repository.StadiumRepository;
import org.springframework.stereotype.Service;

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
}
