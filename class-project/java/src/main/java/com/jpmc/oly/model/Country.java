package com.jpmc.oly.model;

import java.util.Objects;

/**
 * Stores and carries information about a Country
 *
 * Encapsulation (1 of the 3 OOP principals)
 * We put our fields (data) and our methods together in the same block which is our class.
 * It usually includes data protection (private fields accessed only through methods.
 */
public class Country {
    /*
     * Class contains Fields
     */
    private String countryName;

    private String capital;

    /*
     * Class contains Constructors
     */
    public Country() {

    }

    public Country(String countryName, String capital) {
        this.countryName = countryName;
        this.capital = capital;
    }

    /*
     * Class contains Methods
     */

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryName, country.countryName) && Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, capital);
    }

    @Override
    public String toString(){
        return "Country is " + this.countryName + " capital is " + capital;
    }
}
