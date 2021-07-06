package com.jpmc.oly.client;

import com.jpmc.oly.dao.CountryDao;
import com.jpmc.oly.model.Country;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CountryConsoleTest {
    private CountryConsole countryConsole;
    private MockCountryDao mockCountryDao;
    @Before
    public void setUp() throws Exception {
        mockCountryDao = new MockCountryDao();
    }

    @After
    public void tearDown() throws Exception {
        countryConsole = null;
    }

    @Test
    public void getCountry_1_Country() {
        String initialString = "1";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Scanner scanner = new Scanner(targetStream);
        mockCountryDao.AddTestCountry("country1",new Country("country1","cap1"));
        countryConsole = new CountryConsole(scanner,(CountryDao) mockCountryDao);
        Country test = countryConsole.getCountry();
        assertEquals("Country1 did not work",test.getCountryName(),"country1");
    }

    @Test
    public void getCountry_1_exit() {
        String initialString = "2";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Scanner scanner = new Scanner(targetStream);
        mockCountryDao.AddTestCountry("country1",new Country("country1","cap1"));
        countryConsole = new CountryConsole(scanner,(CountryDao) mockCountryDao);
        Country test = countryConsole.getCountry();
        assertNull("Exit did not work for 1 country",test);
    }
    @Test
    public void getCountry_2_countr() {
        String initialString = "2";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Scanner scanner = new Scanner(targetStream);
        mockCountryDao.AddTestCountry("country1",new Country("country1","cap1"));
        mockCountryDao.AddTestCountry("country2",new Country("country2","cap2"));
        countryConsole = new CountryConsole(scanner,(CountryDao) mockCountryDao);
        Country test = countryConsole.getCountry();
        assertEquals("Country2 did not work",test.getCountryName(),"country2");
    }
    @Test
    public void getCountry_2_exit() {
        String initialString = "3";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        Scanner scanner = new Scanner(targetStream);
        mockCountryDao.AddTestCountry("country1",new Country("country1","cap1"));
        mockCountryDao.AddTestCountry("country2",new Country("country2","cap2"));
        countryConsole = new CountryConsole(scanner,(CountryDao) mockCountryDao);
        Country test = countryConsole.getCountry();
        assertNull("Country2 exit did not work",test);
    }
}