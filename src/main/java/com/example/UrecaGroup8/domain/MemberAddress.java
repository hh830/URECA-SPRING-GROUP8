package com.example.UrecaGroup8.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_address")
public class MemberAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addr1;
    private String addr2;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private Member member;

    @Builder
    public MemberAddress(String addr1, String addr2, String zipCode, Member member) {
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.zipCode = zipCode;
        this.member = member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
