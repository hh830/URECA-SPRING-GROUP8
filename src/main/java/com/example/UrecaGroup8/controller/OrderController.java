package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.dto.OrdersAddDto;
import com.example.UrecaGroup8.dto.OrdersDto;
import com.example.UrecaGroup8.dto.ProductDto;
import com.example.UrecaGroup8.dto.ResultDto;
import com.example.UrecaGroup8.repository.OrderRepository;
import com.example.UrecaGroup8.service.MemberService;
import com.example.UrecaGroup8.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService

    @GetMapping("/")
    public List<OrdersDto> listOrders(@RequestParam("memberId") int id){
        List<OrdersDto> list = orderService.listOrders(id);
        return list;
    }

    @PostMapping("/save")
    public ResponseEntity<ResultDto> addOrders(@RequestBody OrdersAddDto ordersAddDto){
        orderService.insertOrders(ordersAddDto);
    }
}
