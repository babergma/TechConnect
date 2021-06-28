package com.jpmc.oly;

import com.jpmc.oly.client.CountryConsole;
import com.jpmc.oly.dao.CountryDaoFile;
import com.jpmc.oly.model.Country;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        System.out.println("Hello From Our Olympic Stats App!");

        /*
         * Wire together our application
         * CountryConsole has dependencies on Scanner and CountryDao, so
         * create instances for each which will be shared across our
         * application and pass them into the CountryConsole's constructor.
         *
         * The CountryDao loads it's data (all the countries) inside it's
         * constructor.
         *
         * We loop prompting the user to select a Country from the menu
         * inside CountryConsole and display the currently selected
         * Country until the user selects Exit.
         *
         * Our application is extensible as we could plug in a different
         * way to interact with the client without needing to change the
         * resource integration work done by the CountryDao. We can also
         * change the way we work with our resource layer (go from
         * File System to Database) without having to change our client
         * layer (we still have work to do to achieve this piece).
         *
         * Change...
         */
        Scanner scanner = new Scanner(System.in);

        CountryDaoFile countryDao = new CountryDaoFile();

        CountryConsole countryConsole = new CountryConsole(scanner, countryDao);

        while (true) {
            Country currentCountry = countryConsole.getCountry();
            if (currentCountry == null){
                System.exit(0);
            }
            System.out.println("Current country is " + currentCountry.getCountryName() +
                    " Capital is " + currentCountry.getCapital());
        }

    }
}
