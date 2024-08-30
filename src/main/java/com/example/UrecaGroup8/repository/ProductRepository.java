package com.example.UrecaGroup8.repository;

import com.example.UrecaGroup8.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
