package com.example.UrecaGroup8.repository;

import com.example.UrecaGroup8.domain.Orders;
import com.example.UrecaGroup8.domain.dto.OrdersResponseDtoV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepositoryV1 extends JpaRepository<Orders,Long> {
    @Query("SELECT new com.example.UrecaGroup8.domain.dto.OrdersResponseDtoV1(o.id, o.member.name, o.product.name, o.orderDate, o.orderQuantity) " +
            "FROM Orders o WHERE o.member.id = :id order by o.orderDate desc")
    List<OrdersResponseDtoV1> listOrders(@Param("id") Long id);

}
