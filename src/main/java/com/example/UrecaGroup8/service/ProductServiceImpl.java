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
                null,  // ID는 데이터베이스에 의해 자동 생성됩니다.
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity() != null ? productDto.getQuantity() : 0, // quantity가 null인 경우 0으로 설정
                productDto.getCountry()
        );
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
