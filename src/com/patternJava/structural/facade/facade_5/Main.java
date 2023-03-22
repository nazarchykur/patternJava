package com.patternJava.structural.facade.facade_5;

public class Main {
    public static void main(String[] args) {
        SimpleLandLord simpleLandLord = new SimpleLandLord();
        
        simpleLandLord.addApartment(new Apartment("John", "Wall Street 1", 5000));
        simpleLandLord.addApartment(new Apartment("Sally", "Baker Street 20", 4000));
        simpleLandLord.addApartment(new Apartment("Tim", "Broadway 110", 2500));
        simpleLandLord.addApartment(new Apartment("Jane", "Green Street 90B", 1000));
        
        simpleLandLord.collectRent();
    }
}
