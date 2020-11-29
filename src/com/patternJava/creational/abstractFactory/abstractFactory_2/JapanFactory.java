package com.patternJava.creational.abstractFactory.abstractFactory_2;

public class JapanFactory implements TransportFactory {
    @Override
    public Car createCar() {
        return new Toyota() ;
    }

    @Override
    public Aircraft createAircraft() {
        return new Boeing();
    }
}
