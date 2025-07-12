package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {
        List<Country> countries = loadCountriesFromXML();
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    private List<Country> loadCountriesFromXML() {
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream("/country.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            NodeList nodes = doc.getElementsByTagName("country");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                Country country = new Country();
                country.setCode(element.getElementsByTagName("code").item(0).getTextContent());
                country.setName(element.getElementsByTagName("name").item(0).getTextContent());
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
}