package com.example.UrecaGroup8.service;

import com.example.UrecaGroup8.domain.Member;
import com.example.UrecaGroup8.domain.MemberAddress;
import com.example.UrecaGroup8.domain.dto.MemberAddressDto;
import com.example.UrecaGroup8.repository.MemberAddressRepository;
import com.example.UrecaGroup8.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberAddressRepository memberAddressRepository;

    @Transactional
    public MemberAddressDto addAddress(Long memberId, MemberAddressDto memberAddressDto) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isEmpty()) {
            throw new RuntimeException("회원이 없습니다.");
        }

        Member member = memberOptional.get();
        memberAddressDto.setMemberId(memberId);
        memberAddressRepository.save(memberAddressDto.toEntity(memberAddressDto,member));
        return memberAddressDto;
    }

}
