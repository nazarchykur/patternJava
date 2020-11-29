package com.patternJava.creational.abstractFactory.abstractFactory_1.website;

import com.patternJava.creational.abstractFactory.abstractFactory_1.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("php code for website ...");
    }
}
