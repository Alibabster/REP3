package com.example.library.repository;

import com.example.library.entities.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> {
    BookIssue getById(Integer id);
}
