package com.patternJava.creational.prototype.prototype_3;

public class CheeseCake implements Cake {

    private String sugar;
    private String butter;
    private String cheese;
    private String name;

    @Override
    public Cake prepareCake() {
        Cake cake;
        try {
            cake = (Cake) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cake;
    }

    void addSugar(String sugar) {
        this.sugar = sugar;
    }

    void addButter(String butter) {
        this.butter = butter;
    }

    public void addCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CheeseCake{" +
                "sugar='" + sugar + '\'' +
                ", butter='" + butter + '\'' +
                ", cheese='" + cheese + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
