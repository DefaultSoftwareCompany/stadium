package com.dsc.stadium.mapper;

import com.dsc.stadium.domain.Stadium;
import com.dsc.stadium.dto.StadiumDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StadiumMapper {
    Stadium toEntity(StadiumDto dto);

    StadiumDto toDto(Stadium user);
}
