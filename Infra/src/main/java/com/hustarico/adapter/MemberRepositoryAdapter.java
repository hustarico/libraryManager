package com.hustarico.adapter;

import com.hustarico.mapper.MemberMapper;
import com.hustarico.model.Member;
import com.hustarico.port.MemberRepository;
import com.hustarico.repository.SpringDataMemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class MemberRepositoryAdapter implements MemberRepository {

    private final SpringDataMemberRepository springDataMemberRepository;



    @Override
    public Member save(Member member) {
        var memberJpaEntity = MemberMapper.toInfra(member);
        var persistedJpaMember = springDataMemberRepository.save(memberJpaEntity);
        return MemberMapper.toDomain(persistedJpaMember);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return springDataMemberRepository.findById(id).map(MemberMapper::toDomain);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return springDataMemberRepository.findByName(name).map(MemberMapper::toDomain);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return springDataMemberRepository.findByEmail(email).map(MemberMapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return springDataMemberRepository.findAll().stream().map(MemberMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        springDataMemberRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataMemberRepository.existsByEmail(email);
    }
}
