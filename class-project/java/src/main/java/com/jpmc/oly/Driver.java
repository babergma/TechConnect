package com.jpmc.oly;

import com.jpmc.oly.client.CountryConsole;
import com.jpmc.oly.dao.CountryDao;
import com.jpmc.oly.dao.CountryDaoDb;
import com.jpmc.oly.dao.CountryDaoFile;
import com.jpmc.oly.exception.CountryLoadException;
import com.jpmc.oly.model.Country;
import com.jpmc.oly.model.Person;
import com.jpmc.oly.model.Player;
import com.jpmc.oly.model.Sport;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        System.out.println("Hello From Our Olympic Stats App!");

//        Sport basketball = new Sport("Basketball");
//        Player player1 = new Player("Joesph", 99, basketball);
//
//        System.out.println(player1);

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
         */
        Scanner scanner = new Scanner(System.in);


        CountryDao countryDao = null;
//        try {
//            countryDao = new CountryDaoFile(); // or new CountryDaoDb for database access
//        } catch (CountryLoadException ex){
//            // Log the exception
//            // Give generic information back to user (security)
//            System.out.println("Problem starting application... please contact your administrator");
//        }
        countryDao = new CountryDaoFile();
                                                      // only 1 place in our application we need to change

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
