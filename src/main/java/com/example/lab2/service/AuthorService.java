package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> getAuthor(Long id);

    public Author save(String name, String surname, Country country);
}
