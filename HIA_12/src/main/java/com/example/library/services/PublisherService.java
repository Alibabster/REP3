package com.example.library.services;

import com.example.library.entities.Publisher;
import java.util.List;

public interface PublisherService {
    void create(Publisher publisher);
    List<Publisher> getAll();
    Publisher getById(Integer id);
}
