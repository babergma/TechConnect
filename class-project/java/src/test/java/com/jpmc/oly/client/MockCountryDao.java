package com.jpmc.oly.client;

import com.jpmc.oly.dao.CountryDao;
import com.jpmc.oly.model.Country;

import java.util.HashMap;
import java.util.Map;

public class MockCountryDao implements CountryDao {
    private Map<String, Country> testCountries = new HashMap<>();
    @Override
    public void saveCountry(Country country) {

    }

    @Override
    public Country getCountry(String countryName) {
        return null;
    }

    @Override
    public Country[] getCountries() {
        return testCountries.values().toArray(new Country[testCountries.size()]);
    }

    @Override
    public void loadCountries() {

    }

    @Override
    public void writeCountries() {

    }
    public void AddTestCountry(String countryName, Country testCountry) {
        testCountries.put(countryName,testCountry);
    }
}
