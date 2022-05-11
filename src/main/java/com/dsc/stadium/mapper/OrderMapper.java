package com.dsc.stadium.mapper;

import com.dsc.stadium.domain.Order;
import com.dsc.stadium.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "stadium.id", source = "stadiumId")
    })
    Order toEntity(OrderDto dto);

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "stadiumId", source = "stadium.id")
    })
    OrderDto toDto(Order user);
}
