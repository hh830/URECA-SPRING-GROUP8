package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.dto.ProductDto;
import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(ProductDto productDto) {
        productService.saveProduct(productDto);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
}
