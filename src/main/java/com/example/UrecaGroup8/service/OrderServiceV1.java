package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Orders;
import com.example.UrecaGroup8.domain.Product;
import com.example.UrecaGroup8.domain.dto.OrdersAddDtoV1;
import com.example.UrecaGroup8.domain.dto.OrdersDtoV1;
import com.example.UrecaGroup8.domain.dto.OrdersResponseDtoV1;
import com.example.UrecaGroup8.repository.MemberRepository;
import com.example.UrecaGroup8.repository.OrderRepositoryV1;
import com.example.UrecaGroup8.repository.ProductRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import com.example.UrecaGroup8.domain.Member;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV1;
    private final MemberRepository memberRepository;
    private final ProductRepositoryV1 productRepositoryV1;

    public List<OrdersResponseDtoV1> listOrders(Long id) {
        return orderRepositoryV1.listOrders(id);
    }

    @Transactional
    public OrdersDtoV1 insertOrders(OrdersAddDtoV1 ordersAddDtoV1) {

        Optional<Member> memberOptional = memberRepository.findById(ordersAddDtoV1.getUserId());
        Optional<Product> productOptional = productRepositoryV1.findById(ordersAddDtoV1.getProductId());

        // 회원 또는 상품이 존재하지 않는 경우 예외 발생
        if (memberOptional.isEmpty()) {
            throw new RuntimeException("회원 존재 x : " + ordersAddDtoV1.getUserId());
        }
        if (productOptional.isEmpty()) {
            throw new RuntimeException("상품 존재 x : " + ordersAddDtoV1.getProductId());
        }

        Member member = memberOptional.get();
        Product product = productOptional.get();

        // 주문 수량이 재고보다 많은 경우 예외 발생
        if (product.getQuantity() < ordersAddDtoV1.getQuantity()) {
            throw new RuntimeException("재고 부족: " + product.getName());
        }

        try {
            // 주문 객체 생성
            Orders orders = Orders.builder()
                    .orderQuantity(ordersAddDtoV1.getQuantity())
                    .orderDate(ordersAddDtoV1.getOrderDate())
                    .member(member)
                    .product(product)
                    .build();

            // 주문 저장
            Orders result = orderRepositoryV1.save(orders);

            // 제품 수량 업데이트 (-1)
            product.setQuantity(product.getQuantity() - ordersAddDtoV1.getQuantity());
            productRepositoryV1.save(product);

            // 주문 정보 반환
            return new OrdersDtoV1(result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("주문 처리 중 오류 발생");
        }
    }
}
