package com.patternJava.behavioral.TemplateMethod.TemplateMethod_3;

public class SedanCar extends Car {
    @Override
    protected void assembleBody() {
        System.out.println("Assembling sedan body.");
    }

    @Override
    protected void addEngine() {
        System.out.println("Adding V6 engine to sedan.");
    }

    @Override
    protected void addWheels() {
        System.out.println("Adding 4 wheels to sedan.");
    }

    @Override
    protected boolean addElectronics() {
        return true;
    }
}

