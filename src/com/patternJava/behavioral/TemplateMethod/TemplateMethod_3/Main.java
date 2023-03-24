package com.patternJava.behavioral.TemplateMethod.TemplateMethod_3;

public class Main {
    public static void main(String[] args) {
        Car sedan = new SedanCar();
        sedan.buildCar();

        Car sportsCar = new SportsCar();
        sportsCar.buildCar();
        
        /*
            Assembling sedan body.
            Adding V6 engine to sedan.
            Adding 4 wheels to sedan.
            Adding GPS system to car.
            
            Assembling sports car body.
            Adding V8 engine to sports car.
            Adding 4 wheels to sports car.
            Adding advanced GPS system to sports car.
         */
    }
}
