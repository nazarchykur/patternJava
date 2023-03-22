package com.patternJava.structural.flyweight.flyweight_4;

public class CounterTerrorist implements Player {
    private final String TASK;
    private String weapon;

    private static int numPlayers;

    public CounterTerrorist() {
        TASK = "DIFFUSE BOMB";
        numPlayers++;
    }

    public static int getNumPlayers() {
        return numPlayers;
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Counter Terrorist with weapon " + weapon + " | " + "Task is " + TASK);
        System.out.println("hashCode: " + getClass().hashCode());
        System.out.println();
    }
}
