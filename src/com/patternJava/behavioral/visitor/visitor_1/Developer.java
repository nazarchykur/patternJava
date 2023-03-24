package com.patternJava.behavioral.visitor.visitor_1;

public interface Developer {
    void create(ProjectClass projectClass);

    void create(Database database);

    void create(Test test);
}
