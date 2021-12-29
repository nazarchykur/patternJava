package com.patternJava.creational.factory.factory_4;

public class FactoryMain {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();  // Inside Circle::draw() method.

        Shape square = ShapeFactory.getShape("square");
        square.draw(); // Inside Square::draw() method.
    }
}