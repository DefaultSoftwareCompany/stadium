package com.dsc.stadium.controller;

import com.dsc.stadium.dto.OrderDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDto save(@Valid OrderDto orderDto) throws BadRequestException {
        return orderService.save(orderDto);
    }

    @GetMapping
    public List<OrderDto> getOrdersByStadiumId(Integer stadiumId) {
        return orderService.getOrdersByStadiumId(stadiumId);
    }
}
