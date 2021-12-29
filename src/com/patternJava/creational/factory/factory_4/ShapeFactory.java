package com.patternJava.creational.factory.factory_4;

public class ShapeFactory {
    
    private ShapeFactory() {
    }

    public static Shape getShape(String shapeName) {
        Shape shape = null;
        switch (shapeName) {
            case "rectangle":
                shape = new Rectangle();
                break;
            case "square":
                shape = new Square();
                break;
            case "circle":
                shape = new Circle();
                break;
            default:
                throw new RuntimeException("no such type of shape");
        }
        
        return shape;
    }
}

