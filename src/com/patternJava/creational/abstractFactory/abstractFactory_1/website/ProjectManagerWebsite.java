package com.patternJava.creational.abstractFactory.abstractFactory_1.website;

import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectManager;

public class ProjectManagerWebsite implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage website ...");
    }
}
