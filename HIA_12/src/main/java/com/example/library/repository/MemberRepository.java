package com.example.library.repository;

import com.example.library.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member getById(Integer id);
}
