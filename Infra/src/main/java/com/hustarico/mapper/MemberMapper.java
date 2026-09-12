package com.hustarico.mapper;


import com.hustarico.entity.MemberJpaEntity;
import com.hustarico.model.Member;

public class MemberMapper {

    public static Member toDomain(MemberJpaEntity memberJpaEntity){
        return new Member(
                memberJpaEntity.getId(),
                memberJpaEntity.getName(),
                memberJpaEntity.getEmail()
        );
    }

    public static MemberJpaEntity toInfra(Member member){
        return MemberJpaEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
