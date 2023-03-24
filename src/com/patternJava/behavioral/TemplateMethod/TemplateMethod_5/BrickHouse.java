package com.patternJava.behavioral.TemplateMethod.TemplateMethod_5;

public class BrickHouse extends AbstractHouse {
    @Override
    protected void buildFoundation() {
        System.out.println("Building foundation with cement, iron rods, and sand");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building walls with bricks and cement");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building roof with tiles");
    }

    @Override
    protected void furnishHouse() {
        System.out.println("Furnishing the brick house");
    }

    @Override
    protected boolean hasGarden() {
        return true;
    }

    @Override
    protected void buildGarden() {
        System.out.println("Adding beautiful garden to the brick house");
    }
}

