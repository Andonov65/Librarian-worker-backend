package com.example.lab2.service.impl;

import com.example.lab2.model.Author;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthor(Long id) {
        return this.authorRepository.findById(id);
    }
}
