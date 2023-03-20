package com.patternJava.creational.prototype.prototype_4;

public class RedColor extends Color {

    public RedColor() {
        this.colorName = "RED";
    }

    @Override
    void fillColor() {
        System.out.println("filling red color...");
    }
}