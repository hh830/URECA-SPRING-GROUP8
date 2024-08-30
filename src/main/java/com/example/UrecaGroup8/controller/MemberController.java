package com.example.UrecaGroup8.controller;

import com.example.UrecaGroup8.domain.MemberAddress;
import com.example.UrecaGroup8.domain.dto.MemberAddressDto;
import com.example.UrecaGroup8.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/{memberId}/add-address")
    public ResponseEntity<MemberAddressDto> addAddressToMember(
            @PathVariable Long memberId,
            @RequestBody MemberAddressDto memberAddressDto) {

        MemberAddressDto savedAddressDto = memberService.addAddress(memberId, memberAddressDto);
        return ResponseEntity.ok(savedAddressDto);
    }
}
