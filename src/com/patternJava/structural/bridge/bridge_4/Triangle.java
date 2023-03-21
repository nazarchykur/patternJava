package com.patternJava.structural.bridge.bridge_4;

public class Triangle extends Shape {
    protected Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
