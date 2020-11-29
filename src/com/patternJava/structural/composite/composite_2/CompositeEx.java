package com.patternJava.structural.composite.composite_2;

import java.util.ArrayList;
import java.util.List;

public class CompositeEx {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape square1 = new Square();
        Shape triangle1 = new Triangle();

        Shape circle21 = new Circle();
        Shape circle22 = new Circle();
        Shape square2 = new Square();

        ShapeComposite composite1 = new ShapeComposite();
        ShapeComposite composite2 = new ShapeComposite();

        composite1.addComponent(circle1);
        composite1.addComponent(square1);
        composite1.addComponent(triangle1);

        composite2.addComponent(circle21);
        composite2.addComponent(circle22);
        composite2.addComponent(square2);

//        composite1.draw();
//        composite2.draw();

        ShapeComposite composite = new ShapeComposite();
        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();
    }
}

interface Shape{
    void draw();
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Square ...");
    }
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Triangle ...");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Circle ...");
    }
}

class ShapeComposite implements Shape{

    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape shape) {
        components.add(shape);
    }

    public void removeComponent(Shape shape) {
        components.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}