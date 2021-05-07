package com.example.library.services;

import com.example.library.entities.BookIssue;

import java.util.List;

public interface BookIssueService {
    void create(BookIssue bookIssue);
    List<BookIssue> getAll();
    BookIssue getById(Integer id);
}
