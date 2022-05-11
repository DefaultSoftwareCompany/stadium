package com.dsc.stadium.service;

import com.dsc.stadium.domain.Order;
import com.dsc.stadium.domain.Stadium;
import com.dsc.stadium.dto.OrderDto;
import com.dsc.stadium.exceptions.BadRequestException;
import com.dsc.stadium.mapper.OrderMapper;
import com.dsc.stadium.repository.OrderRepository;
import com.dsc.stadium.repository.StadiumRepository;
import com.dsc.stadium.utils.OrderStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final StadiumRepository stadiumRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, StadiumRepository stadiumRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.stadiumRepository = stadiumRepository;
    }

    public List<OrderDto> getOrdersByStadiumId(Integer stadiumId) {
        return orderRepository.findAllByFromAfterAndStadium_IdOrderByFrom(LocalDateTime.now(), stadiumId)
                .stream().map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto save(OrderDto orderDto) throws BadRequestException {
        if (orderDto.getId() != null) {
            throw new BadRequestException("New entity can't have an id!");
        }
        Order order = orderMapper.toEntity(orderDto);
        Stadium stadium = stadiumRepository.getById(orderDto.getStadiumId());
        double hours = (order.getTo().toEpochSecond(ZoneOffset.UTC) - order.getFrom().toEpochSecond(ZoneOffset.UTC)) / 3600D;
        order.setPayment(stadium.getPrice().multiply(BigDecimal.valueOf(hours)));
        LocalDateTime from = order.getFrom();
        LocalDateTime to = order.getTo();
        order.setFrom(LocalDateTime.of(from.getYear(), from.getMonth(), from.getDayOfMonth(), from.getHour(), from.getMinute()));
        order.setTo(LocalDateTime.of(to.getYear(), to.getMonth(), to.getDayOfMonth(), to.getHour(), to.getMinute()));
        order.setStatus(OrderStatus.PENDING);
        return orderMapper.toDto(orderRepository.save(order));
    }
}
