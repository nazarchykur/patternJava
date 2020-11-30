package com.patternJava.structural.decorator.decorator_3;

public class ColorDecorator extends Decorator {
    protected ColorDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.print(" ... added color");
    }
}
