package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.ProductDto;
import com.example.UrecaGroup8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/list"; // Thymeleaf 템플릿 경로
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/add"; // 제품 추가 폼 템플릿
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDto productDto) {
        if (productDto.getQuantity() == null) {
            productDto.setQuantity(0); // null인 경우 기본값 설정
        }
        productService.saveProduct(productDto);
        return "redirect:/products/list"; // 제품 목록으로 리다이렉트
    }
}
