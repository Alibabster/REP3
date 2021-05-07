package com.example.library.controller;

import com.example.library.entities.Account;
import com.example.library.entities.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable("id") Integer id) {
        return publisherRepository.findById(id).get();
    }


    @PostMapping("")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.saveAndFlush(publisher);
    }

    @PatchMapping("/{id}")
    public Publisher updatePublisher(@PathVariable Integer id,
                                 @RequestBody Publisher publisher) {
        publisher.setId(id);
        return publisherRepository.saveAndFlush(publisher);
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Integer id){
        publisherRepository.deleteById(id);
    }
}
