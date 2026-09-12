package com.hustarico.repository;

import com.hustarico.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataMemberRepository extends JpaRepository<MemberJpaEntity,Long> {
    Optional<MemberJpaEntity> findByName(String name);
    Optional<MemberJpaEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
