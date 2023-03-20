package com.patternJava.creational.prototype.prototype_1;

public class Main {
    public static void main(String[] args) {
        Project project = new Project(1, "project name 1", "source code");

        System.out.println("project = " + project);
        // project = Project{id=1, projectName='project name 1', sourceCode='source code'}

        // 1 way
        Project projectCopy = (Project) project.copy();
        System.out.println("projectCopy = " + projectCopy);
        // projectCopy = Project{id=1, projectName='project name 1', sourceCode='source code'}

        // 2 way (better)
        ProjectFactory projectFactory = new ProjectFactory(project);
        Project projectCopy2 = projectFactory.cloneProject();
        System.out.println("projectCopy2 = " + projectCopy2);
        // projectCopy2 = Project{id=1, projectName='project name 1', sourceCode='source code'}

    }
}
