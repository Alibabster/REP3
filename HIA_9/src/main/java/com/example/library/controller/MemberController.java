package com.example.library.controller;

import com.example.library.entities.Member;
import com.example.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") Integer id) {
        return memberRepository.findById(id).get();
    }


    @PostMapping("")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.saveAndFlush(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Integer id,
                                 @RequestBody Member member) {
        member.setId(id);
        return memberRepository.saveAndFlush(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Integer id){
        memberRepository.deleteById(id);
    }
}

