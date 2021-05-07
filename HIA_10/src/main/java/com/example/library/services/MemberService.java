package com.example.library.services;

import com.example.library.entities.Member;

import java.util.List;

public interface MemberService {
    void create(Member member);
    List<Member> getAll();
    Member getById(Integer id);
}
