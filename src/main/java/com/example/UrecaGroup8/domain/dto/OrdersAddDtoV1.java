package com.example.UrecaGroup8.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdersAddDtoV1 {
    private Long userId;
    private Long productId;
    private int quantity;
    private LocalDate orderDate;
}
