package com.patternJava.structural.composite.composite_1;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Developer> developers = new ArrayList<>();

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void removeDeveloper(Developer developer) {
        developers.remove(developer);
    }

    public void createProject() {
        System.out.println("Team create project ...");
        for (Developer developer : developers) {
            developer.writeCode();
        }
    }
}
