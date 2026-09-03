package com.hustarico.port;

import com.hustarico.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
    void deleteById(Long id);
    boolean existsByEmail(String email);
}
