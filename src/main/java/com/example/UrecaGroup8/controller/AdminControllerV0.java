package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.Member;
import com.example.UrecaGroup8.domain.dto.MemberAddressDto;
import com.example.UrecaGroup8.domain.dto.MemberResponse;
import com.example.UrecaGroup8.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminControllerV0 {
    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getMembers() {
        // TODO: 권한이 ROLE_ADMIN인지 확인 필요

        List<Member> members = memberRepository.findAll();

        List<MemberResponse> memberResponses = members.stream()
                .map(MemberResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(memberResponses);
    }
}
