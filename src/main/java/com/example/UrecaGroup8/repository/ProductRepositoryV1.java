package com.example.UrecaGroup8.repository;

import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.ProductDtoV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepositoryV1 extends JpaRepository<Product,Long> {
    @Query("select p from Product p")
    List<ProductDtoV1> listProduct();

    @Query("select p from Product p where p.id = :id")
    ProductDtoV1 detailProduct(@Param("id") Long id);
}
