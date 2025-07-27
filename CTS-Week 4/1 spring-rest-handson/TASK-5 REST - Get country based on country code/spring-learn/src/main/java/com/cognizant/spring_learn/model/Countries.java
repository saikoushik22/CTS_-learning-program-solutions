package com.cognizant.spring_learn.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "countries")
public class Countries {
    private List<Country> countryList;

    @XmlElement(name = "country")
    public List<Country> getCountryList() { return countryList; }
    public void setCountryList(List<Country> countryList) { this.countryList = countryList; }
}