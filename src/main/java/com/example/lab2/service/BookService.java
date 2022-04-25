package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.Category;
import com.example.lab2.model.DTO.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> edit(Long id, String name, String category, Long authorId, Integer availableCopies);
    Optional<Book> editDTO(Long id, BookDto bookDto);
    void delete(Long id);
    Optional<Book> markAsTaken(Long id);
    Optional<Book> addNewBook(String name, String category, Long authorId, Integer availableCopies);
    Optional<Book> addNewBookDTO(BookDto bookDto);
}
