package com.patternJava.behavioral.TemplateMethod.TemplateMethod_3;

public class SportsCar extends Car {
    @Override
    protected void assembleBody() {
        System.out.println("Assembling sports car body.");
    }

    @Override
    protected void addEngine() {
        System.out.println("Adding V8 engine to sports car.");
    }

    @Override
    protected void addWheels() {
        System.out.println("Adding 4 wheels to sports car.");
    }

    @Override
    protected boolean addElectronics() {
        return true;
    }

    @Override
    protected void addGps() {
        System.out.println("Adding advanced GPS system to sports car.");
    }
}

