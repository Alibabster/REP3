package com.example.library.repository;

import com.example.library.entities.BookReservation;
import com.example.library.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre getById(Integer id);
}
