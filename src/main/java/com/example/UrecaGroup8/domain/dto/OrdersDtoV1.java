package com.example.UrecaGroup8.domain.dto;

import com.example.UrecaGroup8.domain.Member;
import com.example.UrecaGroup8.domain.Orders;
import com.example.UrecaGroup8.domain.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdersDtoV1 {
    private Long id;
    private Member member;

    private Product product;

    private LocalDate orderDate;

    private int orderQuantity;

    public OrdersDtoV1(Orders orders){
        this.id = orders.getId();
        this.member = orders.getMember();
        this.product = orders.getProduct();
        this.orderDate = orders.getOrderDate();
        this.orderQuantity = orders.getOrderQuantity();
    }
}
