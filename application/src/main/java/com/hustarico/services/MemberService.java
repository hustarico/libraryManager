package com.hustarico.services;

import com.hustarico.model.Member;
import com.hustarico.port.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member save(String name, String email){
        if(memberRepository.existsByEmail(email))
            throw new RuntimeException("email already used");

        return memberRepository.save(new Member(null,name,email));
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void deleteById(Long id){
        if(memberRepository.findById(id).isEmpty()) throw new RuntimeException("user doesn't exist");
        else memberRepository.deleteById(id);
    }

}
