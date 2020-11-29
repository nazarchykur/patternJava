package com.patternJava.creational.abstractFactory.abstractFactory_2;

/*
 - фабрика для створення сімейства обєктів різних типів (на відмінно
 від фабричного метода, де повертається екземпляр тільки одного тирпу)
 - розширений варіант шаблону "Factory"
 - обєкти всередині фабрики звязані по змісту або по задачі
*/
public class AbstractFactory {

    public static void main(String[] args) {
        TransportFactory factory = selectCountryName("japan");
        Aircraft aircraft = factory.createAircraft();
        Car car = factory.createCar();
        aircraft.flight();
        car.drive();
    }
    public static TransportFactory selectCountryName(String countryName) {
        TransportFactory factory = null;
        switch (countryName) {
            case "ua":
                factory = new UAFactory();
                break;
            case "japan":
                factory = new JapanFactory();
                break;
            default:
                factory = null;
        }
        return factory;
    }
}
