package com.jpmc.oly.dao;

import com.jpmc.oly.exception.CountryLoadException;
import com.jpmc.oly.model.Country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryDaoFile implements CountryDao {

    public static final String COUNTRY_FILE_NAME = "countries.text";

    /**
     * Key - countryName
     */
    private Map<String, Country> countryMap;

    public CountryDaoFile() throws CountryLoadException {

        loadCountries();
    }

    /**
     * Inserts or updates country in the resources layer
     * @param country
     */
    @Override
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
    @Override
    public Country getCountry(String countryName){
        return countryMap.get(countryName);
    }

    /**
     *
     * @return the Collection of all countries in our map
     */
    @Override
    public Country[] getCountries() {
        return countryMap.values().toArray(new Country[countryMap.size()]);
    }

    /**
     * Loads the countries from the resource layer into our map
     */
    @Override
    public void loadCountries() throws CountryLoadException {

        /* General Rules for Exception Handling
         * - You can put as many calls that declare they throws exceptions in a try block
         * - You can stack your catch exception blocks (subclass before super class)
         *   The exception comparison: actualException instanceof catch exception
         * - Unchecked exception is an instanceof RuntimeException (compile will NOT force you to catch)
         *
         */

        // create our Map of Country from the File System
        countryMap = new HashMap<>();

        /* Scanner is an instance of Closable therefore has a close() method, so no need to close scanner
         * Opening Scanner in the try ( ) is called try with resources
         */
        try (Scanner scanner = new Scanner( new File(COUNTRY_FILE_NAME))) {
            /*
             * Check another line exists in the file ( scanner.hasNextLine() )
             * Read the line ( scanner.nextLine() )
             * Process the line:
             * - split the line into tokens ([0] - countryName, [1] - capital)
             * - add the new Country to the map
             *
             */
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                countryMap.put(tokens[0], new Country(tokens[0], tokens[1]));
            }
        } catch (FileNotFoundException ex){
            // do something different...
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex){
            /*
             * In real world you would use a logger
             * Do NOT want System.out.print calls at this level in our application (Resource Integration)
             */
            System.out.println("Error: " + ex.getMessage());
            throw new CountryLoadException("Error processing country file");
        }

        // mock in some Country data until we can implement the code for the File System
//        Country country1 = new Country("Argentina", "Buenos Aires");
//        Country country2 = new Country("Canada", "Ottawa");
//        Country country3 = new Country("USA", "Washington DC");
//        countryMap.put(country1.getCountryName(), country1);
//        countryMap.put(country2.getCountryName(), country2);
//        countryMap.put(country3.getCountryName(), country3);
    }

    /**
     * Write the countries into our resource layer from our map
     */
    @Override
    public void writeCountries(){
        // write our Map of Country to the File System
    }
}
