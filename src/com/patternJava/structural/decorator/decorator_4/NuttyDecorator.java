package com.patternJava.structural.decorator.decorator_4;

public class NuttyDecorator extends IcecreamDecorator {
    public NuttyDecorator(Icecream icecream) {
        super(icecream);
    }

    @Override
    public String makeIcecream() {
        return icecream.makeIcecream() + addNuts();
    }

    private String addNuts() {
        return " + crunchy nuts";
    }
    
}
