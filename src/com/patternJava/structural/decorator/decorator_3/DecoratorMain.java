package com.patternJava.structural.decorator.decorator_3;

/*
Decorator also known as Wrapper
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Component component = new Window();
        component.draw();
        System.out.println("----------------------");

        Component windowWithBorders = new BorderDecorator(new Window());
        windowWithBorders.draw();
        System.out.println("----------------------");

        Component textviewWithBordersAndColors = new ColorDecorator(new BorderDecorator(new TextView()));
        textviewWithBordersAndColors.draw();
    }
}
