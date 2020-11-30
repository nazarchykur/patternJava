package com.patternJava.structural.facade.facade_3;

public class FacadeMain {
    public static void main(String[] args) {
        Door door = new Door();
        door.open();
        TurnKey turnKey = new TurnKey();
        turnKey.turnOn();
        Wheel wheel = new Wheel();
        wheel.turn();

        System.out.println("----------------------------------------");
        // with facade
        CarFacade carFacade = new CarFacade();
        carFacade.go();
    }
}
