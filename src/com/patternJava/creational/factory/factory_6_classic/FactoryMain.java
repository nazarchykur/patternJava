package com.patternJava.creational.factory.factory_6_classic;
/*
================ класична фабрика =============

1) отже є в нас кілька фігур під одним інтерфейсом
2) створюємо фабрику по фігурам = абстрактний клас
3) імплементуємо фабрику для кожного конкретного класу нашої фігури, де наш метод повертає конкретну фігуру
4) викликаємо на змінній фігури потрібні методи = буде виконуватися логіка згідно конкретної фабрики фігури

 */
public class FactoryMain {
    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactoryCircle();
        Shape circle = factory.create();
        circle.draw();  // Inside Circle::draw() method.

        ShapeFactory factorySquare = new ShapeFactorySquare();
        Shape square = factorySquare.create();
        square.draw(); // Inside Square::draw() method.
    }
}