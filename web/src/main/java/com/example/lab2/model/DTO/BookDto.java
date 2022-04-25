package com.example.lab2.model.DTO;

import lombok.Data;

@Data
public class BookDto {

    private String name;

    private String category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, String category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}