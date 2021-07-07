package com.jpmc.oly.dao;

import com.jpmc.oly.exception.CountryLoadException;
import com.jpmc.oly.model.Country;

import java.util.HashMap;

public interface CountryDao {

    void saveCountry(Country country);

    /**
     * Search the countryMap for the countryName
     *
     * @param countryName
     * @return Country if matched or null if not found
     */
    Country getCountry(String countryName);

    /**
     *
     * @return the Collection of all countries in our map
     */
    Country[] getCountries();

    /**
     * Loads the countries from the resource layer into our map
     */
    void loadCountries() throws CountryLoadException;

    /**
     * Write the countries into our resource layer from our map
     */
    void writeCountries();
}
