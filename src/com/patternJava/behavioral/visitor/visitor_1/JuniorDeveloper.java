package com.patternJava.behavioral.visitor.visitor_1;

public class JuniorDeveloper implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Junior write poor code...");
    }

    @Override
    public void create(Database database) {
        System.out.println("Junior create tables...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Junior write tests...");
    }
}
