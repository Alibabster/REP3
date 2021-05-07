package com.example.library.services.impl;

import com.example.library.entities.BookIssue;
import com.example.library.repository.BookIssueRepository;
import com.example.library.services.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueServiceImpl implements BookIssueService {

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Override
    public void create(BookIssue bookIssue) {
        bookIssueRepository.save(bookIssue);
    }

    @Override
    public List<BookIssue> getAll() {
        return bookIssueRepository.findAll();
    }

    @Override
    public BookIssue getById(Integer id) {
        return null;
    }
}
