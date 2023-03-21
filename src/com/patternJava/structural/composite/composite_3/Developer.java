package com.patternJava.structural.composite.composite_3;

public class Developer implements Employee {

    private int id;
    private String name;
    private String position;

    public Developer(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("id: " + id + ", name:" + name);
    }
}
