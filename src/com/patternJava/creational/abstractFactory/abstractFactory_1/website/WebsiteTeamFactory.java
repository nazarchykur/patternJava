package com.patternJava.creational.abstractFactory.abstractFactory_1.website;

import com.patternJava.creational.abstractFactory.abstractFactory_1.Developer;
import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectManager;
import com.patternJava.creational.abstractFactory.abstractFactory_1.ProjectTeamFactory;
import com.patternJava.creational.abstractFactory.abstractFactory_1.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new ProjectManagerWebsite();
    }
}
