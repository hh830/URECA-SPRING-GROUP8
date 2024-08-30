package com.example.UrecaGroup8.domain.dto;

import com.example.UrecaGroup8.domain.Member;
import com.example.UrecaGroup8.domain.MemberAddress;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberAddressDto {
    private String addr1;
    private String addr2;
    private String zipCode;
    private Long memberId;

    // DTO에서 엔티티로 변환
    public MemberAddress toEntity(MemberAddressDto dto, Member member) {
        return MemberAddress.builder()
                .addr1(dto.getAddr1())
                .addr2(dto.getAddr2())
                .zipCode(dto.getZipCode())
                .member(member)
                .build();
    }

}
