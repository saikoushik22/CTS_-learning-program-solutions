package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (Country) context.getBean("in");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (List<Country>) context.getBean("countryList");
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}
