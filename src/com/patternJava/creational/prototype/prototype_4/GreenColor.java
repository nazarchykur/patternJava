package com.patternJava.creational.prototype.prototype_4;

public class GreenColor extends Color {

    public GreenColor() {
        this.colorName = "Green";
    }

    @Override
    void fillColor() {
        System.out.println("filling green color...");
    }
}
