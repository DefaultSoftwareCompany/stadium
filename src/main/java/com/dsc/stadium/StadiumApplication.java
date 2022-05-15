package com.dsc.stadium;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "stadium-api", version = "v1"))
@SecurityScheme(name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic")
@SecurityRequirement(name = "basicAuth")
@SpringBootApplication
public class StadiumApplication {

    public static void main(String[] args) {
        SpringApplication.run(StadiumApplication.class, args);
    }

}