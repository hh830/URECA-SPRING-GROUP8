package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Orders;
import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.dto.OrdersAddDto;
import com.example.UrecaGroup8.dto.OrdersDto;
import com.example.UrecaGroup8.repository.MemberRepository;
import com.example.UrecaGroup8.repository.OrderRepository;
import com.example.UrecaGroup8.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public List<OrdersDto> listOrders(int id) {
        return orderRepository.listOrders(id);
    }

    public Orders insertOrders(OrdersAddDto ordersAddDto) {
        // 회원 및 제품 객체 조회
        Optional<Member> memberOptional = memberRepository.findById(ordersAddDto.getUserId());
        Optional<Product> productOptional = productRepository.findById(ordersAddDto.getProductId());

        // 회원 및 제품이 존재하지 않는 경우 예외 처리
        if (memberOptional.isEmpty()) {
            throw new RuntimeException("Member not found with ID: " + ordersAddDto.getUserId());
        }
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with ID: " + ordersAddDto.getProductId());
        }

        Member member = memberOptional.get();
        Product product = productOptional.get();

        // Orders 엔티티 생성 및 설정
        Orders orders = Orders.builder()
                .orderQuantity(ordersAddDto.getQuantity())
                .orderDate(ordersAddDto.getOrderDate())
                .member(member)
                .product(product)
                .build();

        // Orders 엔티티 저장
        return orderRepository.save(orders);
    }
}
