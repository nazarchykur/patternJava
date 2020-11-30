package com.patternJava.structural.decorator.decorator_3;

public abstract class Decorator implements Component {
    protected Component component;

    protected Decorator(Component component) {
        this.component = component;
    }

    public abstract void afterDraw();

    @Override
    public void draw() {
        component.draw();
        afterDraw();
    }
}
