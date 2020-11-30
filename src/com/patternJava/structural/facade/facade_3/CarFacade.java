package com.patternJava.structural.facade.facade_3;

public class CarFacade {
    private Door door = new Door();
    private TurnKey turnKey = new TurnKey();
    private Wheel wheel = new Wheel();

    public void go() {
        door.open();
        turnKey.turnOn();
        wheel.turn();
    }
}
