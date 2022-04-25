package com.example.lab2.config;

import com.example.lab2.model.Author;
import com.example.lab2.model.Country;
import com.example.lab2.service.AuthorService;
import com.example.lab2.service.BookService;
import com.example.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInatializator {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInatializator(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
        List<Country> countryList=new ArrayList<>();
        List<Author> authorList=new ArrayList<>();
        for(int i=0;i<=5;i++){
            countryList.add( this.countryService.save("Name"+i,"Continent"+i))    ;
        }
        for(int i=0;i<=5;i++){
            authorList.add(this.authorService.save("Name"+i,"Surname"+i,countryList.get(i)))   ;
        }


    }
}
