package com.example.UrecaGroup8.repository;

import com.example.UrecaGroup8.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
