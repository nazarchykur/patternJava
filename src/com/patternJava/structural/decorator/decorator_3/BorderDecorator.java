package com.patternJava.structural.decorator.decorator_3;

public class BorderDecorator extends Decorator {
    protected BorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println(" ... added border");
    }
}
