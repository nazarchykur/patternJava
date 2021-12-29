package com.patternJava.creational.factory.factory_5;

public class FactoryMain {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();  // Inside Circle::draw() method.

        Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
        square.draw(); // Inside Square::draw() method.
    }
}