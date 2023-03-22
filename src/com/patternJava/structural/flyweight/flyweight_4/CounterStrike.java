package com.patternJava.structural.flyweight.flyweight_4;

import java.util.Random;

public class CounterStrike {
    // All player types and weapon (used by getRandPlayerType() and getRandWeapon()
    private static String[] playerType = {"Terrorist", "CounterTerrorist"};
    private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};

    public static void main(String[] args) {
        Player player = null;
        for (int i = 0; i < 10; i++) {
            // getPlayer() is called simply using the class name since the method is a static one
            player = PlayerFactory.getPlayer(getRandPlayerType());

            // Assign a weapon chosen randomly uniformly from the weapon array
            player.assignWeapon(getRandWeapon());

            // Send this player on a mission
            player.mission();
        }
        // show that one type of player created only once
        System.out.println("Total number of CounterTerrorist using constructor = " + CounterTerrorist.getNumPlayers());
        System.out.println("Total number of Terrorist using constructor = " + Terrorist.getNumPlayers());
        System.out.println();
        // if type exist we take if from Factory
        System.out.println("Total number of CounterTerrorist from factory = " + PlayerFactory.totalNumberOfCounterTerrorist);
        System.out.println("Total number of Terrorist from factory = " + PlayerFactory.totalNumberOfTerrorist);
    }

    // Utility methods to get a random player type and weapon
    public static String getRandPlayerType() {
        Random random = new Random();

        // Will return an integer between [0,2)
        int randInt = random.nextInt(playerType.length);

        // return the player stored at index 'randInt'
        return playerType[randInt];
    }

    public static String getRandWeapon() {
        Random random = new Random();

        // Will return an integer between [0,5)
        int randInt = random.nextInt(weapons.length);

        // Return the weapon stored at index 'randInt'
        return weapons[randInt];
    }
}