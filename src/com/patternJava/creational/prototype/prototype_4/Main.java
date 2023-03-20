package com.patternJava.creational.prototype.prototype_4;

public class Main {
    public static void main(String[] args) {
        Color red1 = ColorStore.getColor("red");
        red1.fillColor();
        System.out.println("red1 = " + red1.hashCode()); // red1 = 1580066828

        Color red2 = ColorStore.getColor("red");
        red2.fillColor();
        System.out.println("red2 = " + red2.hashCode()); // red2 = 491044090
        
        
        ColorStore.getColor("green").fillColor();
        ColorStore.getColor("green").fillColor();

    }
}