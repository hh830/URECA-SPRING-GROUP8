package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.dto.ProductDtoV1;
import com.example.UrecaGroup8.repository.ProductRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceV1 {
    private final ProductRepositoryV1 productRepositoryV1;
    public List<ProductDtoV1> listProduct() {
        try {
            List<ProductDtoV1> productDto = productRepositoryV1.listProduct();
            return productDto;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("상품 가져오는 데 문제 발생");
        }
    }


    public ProductDtoV1 detailProduct(Long id) {
        try{
            ProductDtoV1 productDto = productRepositoryV1.detailProduct(id);
            return productDto;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("상품 상세 불러오기 문제 발생");
        }
    }
}
