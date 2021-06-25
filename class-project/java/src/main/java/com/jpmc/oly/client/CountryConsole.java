package com.jpmc.oly.client;

import com.jpmc.oly.dao.CountryDaoFile;
import com.jpmc.oly.model.Country;

import java.util.Collection;
import java.util.Scanner;

/**
 * Displays information about countries to the user (System.out.println)
 * Get information from the user about countries (Scanner -> System.in)
 */
public class CountryConsole {

    /**
     * Used to gather input from the user (dependency)
     */
    private Scanner scanner;

    /**
     * Need our Country Dao to get and save countries (dependency)
     */
    private CountryDaoFile countryDao;

    public CountryConsole(Scanner scanner, CountryDaoFile countryDao){
        this.scanner = scanner;
        this.countryDao = countryDao;
    }

    public Country getCountry() {
        System.out.println("Please select the country:\n");
        Country[] countries = countryDao.getCountries();
        for (int i=0; i < countries.length; i++){
            System.out.println((i+1) + ") " + countries[i]);
        }
        System.out.println(countries.length+1 + ") Exit");
        int menuSelection = Integer.parseInt(scanner.nextLine());
        if (menuSelection > countries.length) {
            return null;
        }
        return countries[menuSelection-1];
    }


}
