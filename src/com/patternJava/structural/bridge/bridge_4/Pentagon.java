package com.patternJava.structural.bridge.bridge_4;

public class Pentagon extends Shape {
    protected Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
