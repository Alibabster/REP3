package com.example.library.repository;

import com.example.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getById(Integer id);
    Book getBookByAuthor(String author);
    Book getBookByStatus(String status);
    Book getBookByTitle(String title);
}
