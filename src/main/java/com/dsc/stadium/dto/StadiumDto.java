package com.dsc.stadium.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StadiumDto implements Serializable {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    private String address;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer ownerId;
}
