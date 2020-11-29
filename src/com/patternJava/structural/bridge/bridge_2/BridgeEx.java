package com.patternJava.structural.bridge.bridge_2;

public class BridgeEx {
    public static void main(String[] args) {
    /*
        ми розділили логіку на дві частини:
          - одна частина - це автомобіль і його тип
          - друга частина - це марка автомобіля
    */
        // ======================================================
    /*
    1)отже абстрактний клас Car через композицію має поле Brand (інтерфейс)
     - Car ініціює це поле у своєму конструкторі
     - також має абстрактний метод showDetails
    сам клас Car має своїх два підкласи, кожен з яких виконує свою логіку по використанню поля Brand
    а конкретно - це:
      - реалізує метод showDetails, де викликає метод на полі = brand.setBrand();

    2) отже ми можемо створити силку парент класу = це абстрактний клас Car
      - по конструктору тільки конкретного його класу (або клас Sedan або Hatchback)
    3) так як ми у конструкторі передаємо поле інтерфейсу Brand, то
       підставити можемо тільки конкретну його імплементацію (або Toyota або Audi)
    */
        // ---------------------------------------------------------------------
//        Car car = new Sedan(new Toyota());
//        car.showDetails();

        Car[] cars = {
            new Sedan(new Toyota()),
            new Sedan(new Audi()),
            new Hatchback(new Audi()),
            new Hatchback(new Toyota())
        };
        for (Car car1 : cars) {
            car1.showDetails();
        }
    }
}
abstract class Car{
    protected Brand brand;
    protected Car(Brand brand) { this.brand = brand;}

    abstract void showDetails();
}
class Sedan extends Car {
    protected Sedan(Brand brand) {
        super(brand);
    }

    @Override
    void showDetails() {
        System.out.print("Sedan -> ");
        brand.setBrand();
    }
}
class Hatchback extends Car{
    protected Hatchback(Brand brand) {
        super(brand);
    }

    @Override
    void showDetails() {
        System.out.print("Hatchback -> ");
        brand.setBrand();
    }
}

interface Brand {
    void setBrand();
}
class Audi implements Brand{
    @Override
    public void setBrand() {
        System.out.println("Audi");
    }
}
class Toyota implements Brand{
    @Override
    public void setBrand() {
        System.out.println("Toyota");
    }
}