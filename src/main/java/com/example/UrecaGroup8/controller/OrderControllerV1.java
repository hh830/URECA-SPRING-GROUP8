package com.example.UrecaGroup8.controller;


import com.example.UrecaGroup8.domain.dto.OrdersAddDtoV1;
import com.example.UrecaGroup8.domain.dto.OrdersDtoV1;
import com.example.UrecaGroup8.domain.dto.OrdersResponseDtoV1;
import com.example.UrecaGroup8.service.OrderServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderServiceV1;

    // 회원 주문 목록 (날짜 내림차순)
    @GetMapping("/list")
    public List<OrdersResponseDtoV1> listOrders(@RequestParam("member") Long id){
        List<OrdersResponseDtoV1> list = orderServiceV1.listOrders(id);
        return list;
    }

    // 회원 주문 하기
    @PostMapping("/save")
    public ResponseEntity<OrdersDtoV1> addOrders(@RequestBody OrdersAddDtoV1 ordersAddDtoV1){
        OrdersDtoV1 ordersDtoCust = orderServiceV1.insertOrders(ordersAddDtoV1);
        return new ResponseEntity<>(ordersDtoCust, HttpStatus.OK);
    }


}
