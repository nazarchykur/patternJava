package com.patternJava.structural.flyweight.flyweight_4;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {
    /* HashMap stores the reference to the object
       of Terrorist(TS) or CounterTerrorist(CT).  */
    private static Map<String, Player> playerMap = new HashMap<>();

    public static int totalNumberOfTerrorist = 0;
    public static int totalNumberOfCounterTerrorist = 0;

    // Method to get a player
    public static Player getPlayer(String type) {
        Player player = null;

        // If an object for TS or CT has already been created simply return its reference 
        if (playerMap.containsKey(type)) {
            player = playerMap.get(type);
            countPlayersByType(type);
        } else {
            // create an object of TS/CT 
            switch (type) {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    player = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    player = new CounterTerrorist();
                    break;
                default:
                    System.out.println("Unreachable code!");
            }

            // Once created insert it into the HashMap
            playerMap.put(type, player);

            countPlayersByType(type);
        }
        return player;
    }

    private static void countPlayersByType(String type) {
        if (type == "Terrorist") {
            totalNumberOfTerrorist++;
        }

        if (type == "CounterTerrorist") {
            totalNumberOfCounterTerrorist++;
        }
    }
}
