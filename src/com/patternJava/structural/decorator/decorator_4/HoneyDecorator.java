package com.patternJava.structural.decorator.decorator_4;

public class HoneyDecorator extends IcecreamDecorator {
    public HoneyDecorator(Icecream icecream) {
        super(icecream);
    }

    @Override
    public String makeIcecream() {
        return icecream.makeIcecream() + addHoney();
    }

    private String addHoney() {
        return " + sweet honey";
    }
    
}
