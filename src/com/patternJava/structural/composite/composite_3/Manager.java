package com.patternJava.structural.composite.composite_3;

public class Manager implements Employee {

    private int id;
    private String name;
    private String position;

    public Manager(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("id: " + id + ", name:" + name);
    }
}
