package com.example.library.controller;

import com.example.library.entities.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }


    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,
                           @RequestBody Book book) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
    }
}
