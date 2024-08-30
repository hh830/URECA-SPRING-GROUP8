package com.example.UrecaGroup8.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrdersResponseDtoV1 {
    private Long id;
    private String memberName;

    private String productName;

    private LocalDate orderDate;

    private int orderQuantity;
}
