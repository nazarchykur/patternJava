package com.patternJava.structural.bridge.bridge_4;

public abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    protected Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}
