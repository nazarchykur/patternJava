package com.patternJava.structural.flyweight.flyweight_2;

import java.util.*;

public class FlyweightMain {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random random = new Random();
        for (Shape shape : shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x,y);
        }

    }
}

interface Shape {
    void draw(int x, int y);
}
class Point implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : draw point");
    }
}
class Circle implements Shape {
    private int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : draw circle with radius " + r);
    }
}
class Square implements Shape {
    private int side = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + ") : draw square with side " + side);
    }
}

class ShapeFactory {
    public static final Map<String, Shape> SHAPES = new HashMap<>();

    public Shape getShape(String shapeName) {
        Shape shape = SHAPES.get(shapeName);

        if (shape == null) {
            switch (shapeName) {
                case "circle":
                    shape = new Circle();
                    break;
                case "point":
                    shape = new
                            Point();
                    break;
                case "square":
                    shape = new Square();
                    break;
            }
            SHAPES.put(shapeName, shape);
        }
        return shape;
    }
}