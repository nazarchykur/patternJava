package com.patternJava.creational.abstractFactory.abstractFactory_1.banking;

import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectManager;

public class ProjectManagerBanking implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("manage banking ...");
    }
}
