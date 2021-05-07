package com.example.library.services;

import com.example.library.entities.BookReservation;

import java.util.List;

public interface BookReservationService {
    void create(BookReservation bookReservation);
    List<BookReservation> getAll();
    BookReservation getById(Integer id);
}
