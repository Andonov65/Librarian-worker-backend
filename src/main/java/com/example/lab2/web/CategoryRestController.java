package com.example.lab2.web;

import com.example.lab2.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://librarian-worker.herokuapp.com"})
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    public Category[] findAll(){
        return Category.values();
    }
}
