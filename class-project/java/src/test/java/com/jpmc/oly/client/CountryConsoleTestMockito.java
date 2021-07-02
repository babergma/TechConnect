package com.jpmc.oly.client;

import com.jpmc.oly.dao.CountryDao;
import com.jpmc.oly.model.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CountryConsoleTestMockito {

    private CountryConsole countryConsole;
    private CountryDao mockCountryDao;

    @Before
    public void setUp() throws Exception {
        mockCountryDao = (CountryDao)mock(CountryDao.class);
        Country[] countries = {
                new Country("country1", "cap1"),
                new Country("country2", "cap2"),
                new Country("country3", "cap3")
        };
        when(mockCountryDao.getCountries()).thenReturn(countries);
    }

    @After
    public void tearDown() throws Exception {
        countryConsole = null;
    }

    @Test
    public void getCountry_1_Country() {
        String countryName = "country1";
        String userInput = "1";
        InputStream targetStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(targetStream);
        countryConsole = new CountryConsole(scanner,(CountryDao) mockCountryDao);
        Country actual = countryConsole.getCountry();
        assertEquals(countryName + " did not work", countryName, actual.getCountryName());
    }
}