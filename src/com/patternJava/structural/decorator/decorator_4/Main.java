package com.patternJava.structural.decorator.decorator_4;

public class Main {
    public static void main(String[] args) {
        Icecream icecream = new SimpleIcecream();
        System.out.println("icecream 1 = " + icecream.makeIcecream()); // icecream 1 = Base Icecream

        Icecream icecream2  = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
        System.out.println("icecream 2 = " + icecream2.makeIcecream()); // icecream 2 = Base Icecream + crunchy nuts + sweet honey

        Icecream icecream3  = new NuttyDecorator(new SimpleIcecream());
        System.out.println("icecream 3 = " + icecream3.makeIcecream()); // icecream 3 = Base Icecream + crunchy nuts
    }
}
