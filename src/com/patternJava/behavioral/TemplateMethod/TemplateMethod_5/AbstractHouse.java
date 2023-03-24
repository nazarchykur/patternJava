package com.patternJava.behavioral.TemplateMethod.TemplateMethod_5;

public abstract class AbstractHouse {
    // template method
    public final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildRoof();
        if (hasGarden()) {
            buildGarden();
        }
        furnishHouse();
        System.out.println();
    }

    protected abstract void buildFoundation();

    protected abstract void buildWalls();

    protected abstract void buildRoof();

    protected abstract void furnishHouse();

    protected void buildGarden() {
        System.out.println("Adding garden to the house");
    }

    protected boolean hasGarden() {
        return false;
    }
}

