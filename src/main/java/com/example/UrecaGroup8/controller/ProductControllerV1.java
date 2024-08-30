package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.dto.ProductDtoV1;
import com.example.UrecaGroup8.service.ProductServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductControllerV1 {
    private final ProductServiceV1 productServiceV1;
    // 전체상품
    @GetMapping("/list")
    public ResponseEntity<List<ProductDtoV1>> listProduct(){
        List<ProductDtoV1> productDto = productServiceV1.listProduct();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    // 상품 상세
    @GetMapping("/list/{id}")
    public ResponseEntity<ProductDtoV1> detailProduct(@PathVariable("id") Long id){
        ProductDtoV1 productDto = productServiceV1.detailProduct(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

}
