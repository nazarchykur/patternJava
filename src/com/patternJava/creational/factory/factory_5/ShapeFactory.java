package com.patternJava.creational.factory.factory_5;

public class ShapeFactory {
    
    private ShapeFactory() {
    }

    public static Shape getShape(ShapeType shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case RECTANGLE:
                shape = new Rectangle();
                break;
            case SQUARE:
                shape = new Square();
                break;
            case CIRCLE:
                shape = new Circle();
                break;
            default:
                throw new RuntimeException("no such type of shape");
        }
        
        return shape;
    }
}

