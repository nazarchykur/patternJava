package com.patternJava.structural.decorator.decorator_4;

public abstract class IcecreamDecorator implements Icecream {
    protected Icecream icecream;

    protected IcecreamDecorator(Icecream icecream) {
        this.icecream = icecream;
    }

    @Override
    public String makeIcecream() {
        return icecream.makeIcecream();
    }
}
