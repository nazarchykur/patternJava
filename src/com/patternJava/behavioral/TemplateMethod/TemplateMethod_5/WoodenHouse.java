package com.patternJava.behavioral.TemplateMethod.TemplateMethod_5;

public class WoodenHouse extends AbstractHouse {
    @Override
    protected void buildFoundation() {
        System.out.println("Building foundation with wood and gravel");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building walls with wood and nails");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building roof with wooden planks");
    }

    @Override
    protected void furnishHouse() {
        System.out.println("Furnishing the wooden house");
    }
}

