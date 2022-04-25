package com.example.lab2.service.impl;

import com.example.lab2.model.Country;
import com.example.lab2.repository.CountryRepository;
import com.example.lab2.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepositroy;

    public CountryServiceImpl(CountryRepository countryRepositroy) {
        this.countryRepositroy = countryRepositroy;
    }

    @Override
    public Country save(String name, String contient) {
        return    this.countryRepositroy.save(new Country(name,contient));
    }
}
