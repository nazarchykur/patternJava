package com.patternJava.structural.decorator.decorator_3;

public class TextView implements Component {
    @Override
    public void draw() {
        System.out.println("draw textview");
    }
}
