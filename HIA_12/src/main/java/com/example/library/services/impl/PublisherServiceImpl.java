package com.example.library.services.impl;

import com.example.library.entities.Publisher;
import com.example.library.repository.PublisherRepository;
import com.example.library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void create(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(Integer id) {
        return publisherRepository.getById(id);
    }
}
