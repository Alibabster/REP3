package com.example.library.services.impl;

import com.example.library.entities.Member;
import com.example.library.repository.MemberRepository;
import com.example.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void create(Member member) {
        memberRepository.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(Integer id) {
        return memberRepository.getById(id);
    }
}
