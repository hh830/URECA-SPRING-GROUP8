package com.example.UrecaGroup8.domain.dto;

import com.example.UrecaGroup8.domain.Product;
import lombok.Data;

@Data
public class ProductDtoV1 {
    private Long id;
    private int quantity;
    private int price;
    private String country;
    private String name;

    public ProductDtoV1(Product product) {
        this.id = product.getId();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.country = product.getCountry();
        this.name = product.getName();
    }
}
