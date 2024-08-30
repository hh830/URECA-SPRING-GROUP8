package com.example.UrecaGroup8.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;
    private String phone;
    private char gender;
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAddress> addresses=new ArrayList<>();

    public void setAddresses(MemberAddress address) {
        this.addresses.add(address);
    }

    public Member(String email, String name, String password, String phone, char gender, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
}
