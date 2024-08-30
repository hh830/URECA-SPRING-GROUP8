package com.example.UrecaGroup8.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private Integer quantity;
    private String country;
}
