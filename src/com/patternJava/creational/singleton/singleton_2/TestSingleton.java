package com.patternJava.creational.singleton.singleton_2;

public class TestSingleton {
    private static TestSingleton instance;

    public static synchronized TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() { }

    public void print() {
        System.out.println(this);
    }
}
