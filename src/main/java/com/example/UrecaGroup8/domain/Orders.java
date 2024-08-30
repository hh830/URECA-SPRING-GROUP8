package com.example.UrecaGroup8.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDate orderDate;

    private int orderQuantity;

    @Builder

    public Orders(Member member, Product product, LocalDate orderDate, int orderQuantity) {
        this.member = member;
        this.product = product;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
    }
}
