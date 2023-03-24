package com.patternJava.behavioral.TemplateMethod.TemplateMethod_3;

public abstract class Car {
    // Template method
    public final void buildCar() {
        assembleBody();
        addEngine();
        addWheels();
        if (addElectronics()) {
            addGps();
        }
        System.out.println();
    }

    protected abstract void assembleBody();

    protected abstract void addEngine();

    protected abstract void addWheels();

    protected boolean addElectronics() {
        return false;
    }

    protected void addGps() {
        System.out.println("Adding GPS system to car.");
    }
}

