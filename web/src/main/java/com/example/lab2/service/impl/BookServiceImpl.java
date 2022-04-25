package com.example.lab2.service.impl;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.Category;
import com.example.lab2.model.DTO.BookDto;
import com.example.lab2.repository.AuthorRepository;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> edit(Long id, String name, String category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(RuntimeException::new);
        Author author = this.authorRepository.findById(authorId).orElseThrow(RuntimeException::new);

        book.setName(name);
        book.setCategory(Category.valueOf(category));
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> editDTO(Long id, BookDto bookDto) {

        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow();
        Book book = this.findById(id).orElseThrow();
        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(RuntimeException::new);
        if(book.getAvailableCopies() == 0)
            return Optional.of(book);

        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> addNewBook(String name, String category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(RuntimeException::new);
        Book book = new Book(name, Category.valueOf(category), author, availableCopies);
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> addNewBookDTO(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow();
        Category bookCategory = Category.valueOf(bookDto.getCategory());


        Book book = new Book(bookDto.getName(), bookCategory,  author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
