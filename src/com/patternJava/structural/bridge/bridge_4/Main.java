package com.patternJava.structural.bridge.bridge_4;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(new RedColor());
        triangle.applyColor(); // Triangle filled with color red.

        Shape pentagon = new Pentagon(new GreenColor());
        pentagon.applyColor(); // Pentagon filled with color green.
    }
}
