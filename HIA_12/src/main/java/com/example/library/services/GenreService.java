package com.example.library.services;

import com.example.library.entities.Genre;

import java.util.List;

public interface GenreService {
    void create(Genre genre);
    List<Genre> getAll();
    Genre getById(Integer id);
}
