package com.dsc.stadium.repository;

import com.dsc.stadium.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByFromAfterAndStadium_IdOrderByFrom(LocalDateTime from, Integer stadiumId);
}
