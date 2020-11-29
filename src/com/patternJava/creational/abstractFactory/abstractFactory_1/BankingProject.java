package com.patternJava.creational.abstractFactory.abstractFactory_1;

import com.patternJava.creational.abstractFactory.abstractFactory_1.banking.BankingTeamFactory;

public class BankingProject {
    public static void main(String[] args) {
        ProjectTeamFactory bankingTeamFactory = new BankingTeamFactory();
        Developer developer = bankingTeamFactory.getDeveloper();
        Tester tester = bankingTeamFactory.getTester();
        ProjectManager projectManager = bankingTeamFactory.getProjectManager();

        System.out.println("creating banking ...");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
