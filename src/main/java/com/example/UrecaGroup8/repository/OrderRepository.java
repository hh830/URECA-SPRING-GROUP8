package com.example.UrecaGroup8.repository;

import com.example.UrecaGroup8.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
