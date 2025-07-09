package com.codewithudo.countryinformationapi.service;

import com.codewithudo.countryinformationapi.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final List<Country> countries = new ArrayList<>();
    private int nextId = 1;

    // Add a new country  || Not Needed Any More
//    public boolean addCountry(Country country) {
//        country.setId(nextId++);
//        countries.add(country);
//        return true;
//    }

    // Get all countries || Not Needed Any More
//    public List<Country> getAllCountries() {
//        return countries;
//    }

//    // Get a country by ID || Will be fixed Soon
//    public Country getCountryById(int id) {
//        for (Country country : countries) {
//            if (country.getId().equals(id)) {
//                return country;
//            }
//        }
//        return null;
//    }

    // Get a country by Name || Not Needed Any More
//    public Country getCountryByName(String name) {
//        for (Country country : countries) {
//            if (country.getName().equals(name)) {
//                return country;
//            }
//        }
//        return null;
//    }

    // Update a country by ID || Not Needed Any More
//    public boolean updateCountry(int id, Country updatedCountry) {
//        for (Country country : countries) {
//            if (country.getId().equals(id)) {
//                country.setName(updatedCountry.getName());
//                country.setCapital(updatedCountry.getCapital());
//                country.setRegion(updatedCountry.getRegion());
//                country.setPopulation(updatedCountry.getPopulation());
//                country.setCurrency(updatedCountry.getCurrency());
//                return true;
//            }
//        }
//        return false;
//    }

//    // Delete a country by ID || Not Needed Any More
//    public boolean deleteCountry(int id) {
//        return countries.removeIf(country -> country.getId().equals(id));
//    }
}
