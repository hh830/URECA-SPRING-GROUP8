package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.ProductDto;
import com.example.UrecaGroup8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        Product product = new Product(
                null,  // ID는 보통 데이터베이스에 의해 자동 생성됩니다.
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                productDto.getCountry()
        );
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
