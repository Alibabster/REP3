package com.example.library.services.impl;

import com.example.library.entities.Genre;
import com.example.library.repository.GenreRepository;
import com.example.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getById(Integer id) {
        return genreRepository.getById(id);
    }
}
