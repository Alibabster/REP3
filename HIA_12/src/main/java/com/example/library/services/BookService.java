package com.example.library.services;

import com.example.library.entities.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    List<Book> getAll();
    Book getById(Integer id);
}
