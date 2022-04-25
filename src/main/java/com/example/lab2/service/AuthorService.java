package com.example.lab2.service;

import com.example.lab2.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> getAuthor(Long id);
}
