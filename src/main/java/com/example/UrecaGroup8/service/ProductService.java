package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDto productDto);
    List<Product> getAllProducts();
}
