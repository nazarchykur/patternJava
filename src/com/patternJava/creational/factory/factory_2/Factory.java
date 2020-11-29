package com.patternJava.creational.factory.factory_2;
/*
 - інтерфейс відомий, але наперед невідомо яка його реалізація буде використовуватися
 - отримання силки на обєкт в залежності від вхідних параметрів
*/

public class Factory {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("toyota");
        car.drive();
    }
}

interface Car {
    void drive();
}
class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("audi drive");
    }
}
class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("toyota drive");
    }
}

class CarFactory {
    public Car getCar(String carModel) {
        Car car = null;
        switch (carModel) {
            case "audi":
                car = new Audi();
                break;
            case "toyota":
                car = new Toyota();
                break;
            default:
                car = null;
        }
        return car;
    }
}
