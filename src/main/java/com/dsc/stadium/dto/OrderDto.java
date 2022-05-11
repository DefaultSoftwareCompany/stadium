package com.dsc.stadium.dto;

import com.dsc.stadium.utils.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto implements Serializable {
    private Long id;
    @NotNull
    private Integer stadiumId;
    @NotNull
    private Integer userId;
    @NotNull
    private LocalDateTime from;
    @NotNull
    private LocalDateTime to;
    private OrderStatus status;
    private BigDecimal payment;
}
