package com.dsc.stadium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String description;
    private Double distance;
}
