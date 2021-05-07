package com.example.library.repository;

import com.example.library.entities.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReservationRepository extends JpaRepository<BookReservation, Integer> {
    BookReservation getById(Integer id);
}
