package com.dsc.stadium.mapper;

import com.dsc.stadium.domain.Authority;
import com.dsc.stadium.domain.User;
import com.dsc.stadium.dto.UserDto;
import com.dsc.stadium.utils.AuthorityConstants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mappings({
            @Mapping(target = "login", expression = "java(dto.getLogin().toLowerCase())")
    })
    User toEntity(UserDto dto);

    UserDto toDto(User user);

    @Mappings(
            @Mapping(
                    target = "authority.authority", source = "authorityConstants"
            ))
    Authority toEntity(AuthorityConstants authorityConstants);

    default AuthorityConstants toDto(Authority authority) {
        return authority.getAuthority();
    }
}
