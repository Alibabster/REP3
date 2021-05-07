package com.example.library.services.impl;

import com.example.library.entities.BookReservation;
import com.example.library.repository.BookReservationRepository;
import com.example.library.services.BookReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    @Autowired
    private BookReservationRepository bookReservationRepository;

    @Override
    public void create(BookReservation bookReservation) {
        bookReservationRepository.save(bookReservation);
    }

    @Override
    public List<BookReservation> getAll() {
        return bookReservationRepository.findAll();
    }

    @Override
    public BookReservation getById(Integer id) {
        return bookReservationRepository.getById(id);
    }
}
