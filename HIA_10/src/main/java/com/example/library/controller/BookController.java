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

    @GetMapping("/{author}")
    public Book getBookByAuthor(@PathVariable("author") String author){
        return bookRepository.getBookByAuthor(author);
    }

    @GetMapping("/{author}")
    public Book getBookByTitle(@PathVariable("title") String title){
        return bookRepository.getBookByTitle(title);
    }

    @GetMapping("/{status}")
    public Book getBookByStatus(@PathVariable("status") String status){
        return bookRepository.getBookByStatus(status);
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
