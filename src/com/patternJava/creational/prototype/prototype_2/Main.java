package com.patternJava.creational.prototype.prototype_2;

public class Main {
    public static void main(String[] args) {
        PrototypeCache prototypeCache = new PrototypeCache();
        prototypeCache.loadCache();

        VegBurger vegBurger = (VegBurger) prototypeCache.getBurger("veg");
        System.out.println("Name: " + vegBurger.getName());
        System.out.println("Price: " + vegBurger.getPrice() + "/-");
        System.out.println("Description: " + vegBurger.getDescription());

        System.out.println();

        ChickenBurger chickenBurger = (ChickenBurger) prototypeCache.getBurger("chicken");
        System.out.println("Name: " + chickenBurger.getName());
        System.out.println("Price: " + chickenBurger.getPrice() + "/-");
        System.out.println("Description: " + chickenBurger.getDescription());
    }
}
