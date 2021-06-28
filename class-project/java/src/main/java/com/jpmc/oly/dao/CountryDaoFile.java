package com.jpmc.oly.dao;

import com.jpmc.oly.model.Country;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountryDaoFile {
    /**
     * Key - countryName
     */
    private Map<String, Country> countryMap;

    public CountryDaoFile() {
        loadCountries();
    }

    /**
     * Inserts or updates country in the resources layer
     * @param country
     */
    public void saveCountry(Country country){
        // update countryMap if key already there or insert if key is not there
        countryMap.put(country.getCountryName(), country);
    }

    /**
     * Search the countryMap for the countryName
     *
     * @param countryName
     * @return Country if matched or null if not found
     */
    public Country getCountry(String countryName){
        return countryMap.get(countryName);
    }

    /**
     *
     * @return the Collection of all countries in our map
     */
    public Country[] getCountries() {
        return countryMap.values().toArray(new Country[countryMap.size()]);
    }

    /**
     * Loads the countries from the resource layer into our map
     */
    public void loadCountries(){
        // create our Map of Country from the File System
        countryMap = new HashMap<>();

        // mock in some Country data until we can implement the code for the File System
        Country country1 = new Country("Argentina", "Buenos Aires");
        Country country2 = new Country("Canada", "Ottawa");
        Country country3 = new Country("USA", "Washington DC");
        countryMap.put(country1.getCountryName(), country1);
        countryMap.put(country2.getCountryName(), country2);
        countryMap.put(country3.getCountryName(), country3);
    }

    /**
     * Write the countries into our resource layer from our map
     */
    public void writeCountries(){
        // write our Map of Country to the File System
    }
}
