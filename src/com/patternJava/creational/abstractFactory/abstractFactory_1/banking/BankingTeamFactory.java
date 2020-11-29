package com.patternJava.creational.abstractFactory.abstractFactory_1.banking;

import com.patternJava.creational.abstractFactory.abstractFactory_1.Developer;
import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectManager;
import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectTeamFactory;
import com.patternJava.creational.abstractFactory.abstractFactory_1.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new ProjectManagerBanking();
    }
}
