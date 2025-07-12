package com.cognizant.spring_learn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;

@RestController
@RequestMapping
public class CountryController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        return context.getBean("IN", Country.class);
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return context.getBean("countryList", List.class);
    }
}
