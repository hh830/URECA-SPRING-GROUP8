package com.example.UrecaGroup8.domain.dto;

import com.example.UrecaGroup8.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberResponse {
    private Long id;
    private String email;
    private String name;
    private String password;
    private String phone;
    private char gender;
    private String role;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.password = member.getPassword();
        this.phone =  member.getPhone();
        this.gender = member.getGender();
        this.role = member.getRole();
    }
}
