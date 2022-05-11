package com.dsc.stadium;

import com.dsc.stadium.domain.Authority;
import com.dsc.stadium.dto.UserDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.repository.AuthorityRepository;
import com.dsc.stadium.service.UserService;
import com.dsc.stadium.utils.AuthorityConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Stadium Api", version = "v1"))
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class StadiumApplication {

    public static void main(String[] args) throws BadRequestException {
        ConfigurableApplicationContext context = SpringApplication.run(StadiumApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        AuthorityRepository authorityRepository = context.getBean(AuthorityRepository.class);
        authorityRepository.save(new Authority(AuthorityConstants.USER));
        authorityRepository.save(new Authority(AuthorityConstants.OWNER));
        authorityRepository.save(new Authority(AuthorityConstants.ADMIN));
        userService.save(new UserDto(null, "user", "user", "User", "User", "user", Set.of(AuthorityConstants.USER)));
        userService.save(new UserDto(null, "owner", "owner", "Owner", "Owner", "owner", Set.of(AuthorityConstants.USER, AuthorityConstants.OWNER)));
        userService.save(new UserDto(null, "admin", "admin", "Admin", "Admin", "admin", Set.of(AuthorityConstants.USER, AuthorityConstants.OWNER, AuthorityConstants.ADMIN)));
    }

}