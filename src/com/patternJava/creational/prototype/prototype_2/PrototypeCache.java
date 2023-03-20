package com.patternJava.creational.prototype.prototype_2;

import java.util.Hashtable;

public class PrototypeCache {
    private Hashtable<String, Burger> burgerTable = new Hashtable<>();

    public Burger getBurger(String type) {
        Burger cachedBurger = burgerTable.get(type);

        return (Burger) cachedBurger.clone();
    }

    public void loadCache() {
        VegBurger vegBurger = new VegBurger();
        vegBurger.setName("Veg Bur");
        vegBurger.setDescription("Contains different vegetables");

        burgerTable.put("veg", vegBurger);

        ChickenBurger chickenBurger = new ChickenBurger();
        chickenBurger.setName("Chicken Bur");
        chickenBurger.setDescription("Contains different vegetables and cheese and chicken");

        burgerTable.put("chicken", chickenBurger);
    }
}
