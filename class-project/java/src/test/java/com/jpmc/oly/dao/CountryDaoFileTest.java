package com.jpmc.oly.dao;

import com.jpmc.oly.model.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matcher.*;

public class CountryDaoFileTest {

    /*
     * JUnit 5 also offers 2 additional annotations:
     * @BeforeClass
     *  - Is called when the test class is run at the very beginning
     *
     * @AfterClass
     * - Is called after all the test have run before ending the test process
     */

    private CountryDaoFile cut;

    /*
     * Is called before each test method runs
     *
     * Each test runs in isolation (remove any state or side effects from a previous test)
     */
    @Before
    public void setUp() throws Exception {
        cut = new CountryDaoFile();
    }

    /*
     * Is called after each test method runs
     */
    @After
    public void tearDown() throws Exception {
        // System.out.println("After test tearDown");
    }

    @Test
    // Acceptable naming convention for test methods: get_country_where_key_is_argentina
    public void getCountryWhereKeyIsArgentina() {
        Country actual = cut.getCountry("Argentina");
        Country expected = new Country("Argentina", "Buenos Aires");
        assertEquals("Country should be Argentina", expected, actual);
    }

    @Test
    // Acceptable naming convention for test methods: get_country_where_key_is_argentina
    public void getCountryWhereKeyIsUSA() {
        Country actual = cut.getCountry("USA");
        Country expected = new Country("USA", "Washington DC");
        assertEquals("Country should be USA", expected, actual);
    }

    @Test
    public void getCountries() {
    }
}