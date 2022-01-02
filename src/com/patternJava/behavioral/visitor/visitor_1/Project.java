package com.patternJava.behavioral.visitor.visitor_1;

public class Project implements ProjectElement {
    public ProjectElement[] projectElements;

    public Project() {
        projectElements = new ProjectElement[]{
                new ProjectClass(),
                new Database(),
                new Test()};

    }

    @Override
    public void beWritten(Developer developer) {
        for (ProjectElement projectElement : projectElements) {
            projectElement.beWritten(developer);
        }
    }
}
