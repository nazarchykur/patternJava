package com.patternJava.creational.factory.factory_6_classic;

public class ShapeFactoryCircle extends ShapeFactory {
    
    @Override
    public Shape create() {
        return new Circle();
    }
}
