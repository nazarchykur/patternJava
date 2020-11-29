package com.patternJava.creational.builder.builder_2;

public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("audi")
                .buildTransmission(Transmission.MANUAL)
                .buildMaxSpeed(180)
                .build();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder {
    private String make = "default";
    private Transmission transmission = Transmission.MANUAL;
    private int maxSpeed = 180;

    CarBuilder buildMake(String make) {
        this.make = make;
        return this;
    }
    public CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }
    public CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setMake(make);
        car.setTransmission(transmission);
        car.setMaxSpeed(maxSpeed);
        return car;
    }
}