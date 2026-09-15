package com.hustarico.rest;


import com.hustarico.dto.CreateMemberRequest;
import com.hustarico.model.Member;
import com.hustarico.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @GetMapping("")
    public ResponseEntity<List<Member>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Member> createMember(@RequestBody CreateMemberRequest createMemberRequest) {
        return ResponseEntity.ok(memberService.save(
                createMemberRequest.name(),
                createMemberRequest.email()
        ));
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable(name = "memberId") Long memberId) {
        memberService.deleteById(memberId);
    }
}
