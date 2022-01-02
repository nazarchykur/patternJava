package com.patternJava.behavioral.visitor.visitor_1;

public class SeniorDeveloper implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Senior check code after junior...");
    }

    @Override
    public void create(Database database) {
        System.out.println("Senior correct tables...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Senior rewrite tests...");
    }
}
