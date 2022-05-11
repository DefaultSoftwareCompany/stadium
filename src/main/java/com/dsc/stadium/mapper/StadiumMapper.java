package com.dsc.stadium.mapper;

import com.dsc.stadium.domain.Stadium;
import com.dsc.stadium.dto.StadiumDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StadiumMapper {
    @Mappings(@Mapping(target = "owner.id", source = "ownerId"))
    Stadium toEntity(StadiumDto dto);

    @Mappings(@Mapping(target = "ownerId", source = "owner.id"))
    StadiumDto toDto(Stadium user);
}
