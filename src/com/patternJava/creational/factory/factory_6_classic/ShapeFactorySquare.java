package com.patternJava.creational.factory.factory_6_classic;

public class ShapeFactorySquare extends ShapeFactory {
    @Override
    public Shape create() {
        return new Square();
    }
}
