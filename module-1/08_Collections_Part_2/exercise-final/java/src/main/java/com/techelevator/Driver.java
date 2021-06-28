package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args){

        try {
            int number = Integer.parseInt("42");
            System.out.println("All Good!");
        } catch (NumberFormatException ex){
            System.out.println("Error: " + ex.getMessage());

        }

        // Allocates Player objects on the heap and stores the reference in player1, ... local variables on the stack
        Player player1 = new Player("Imani", 1);
        Player player2 = new Player("Tarik", 2);
        Player player3 = new Player("Serene", 3);

        // Defines a local stack variable that will hold a reference to a map on the heap
        Map<String, Player> playerMap = null;

        // Allocates the map on the heap and assigns the reference to it's local stack variable
        playerMap = new HashMap<>();

        // Put our Player object references into the Map Key: Country Name Value: Player object reference
        // Map.Entry is the key, value pair
        playerMap.put("A", player1);
        playerMap.put("C", player2);
        playerMap.put("U", player3);

        // Loop through by "give me all the keys" and I'll loop through each key
        // keySet will return a set ["A", "C", "U")]
        for (String currentCountry : playerMap.keySet()){
            System.out.println(playerMap.get(currentCountry)); // currentCountry is the key "A" or "C" or "U"
        }

        // "Give me all the Map.Entry and I'll loop through each Entry (.getKey() and .getValue() )

        // "Give me all the values and I'll just loop through each value


    }
}
