package com.patternJava.creational.abstractFactory.abstractFactory_1;

import com.patternJava.creational.abstractFactory.abstractFactory_1.website.WebsiteTeamFactory;

public class WebsiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebsiteTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("create website ...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();


    }
}
