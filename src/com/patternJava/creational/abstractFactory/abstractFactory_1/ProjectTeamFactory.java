package com.patternJava.creational.abstractFactory.abstractFactory_1;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
