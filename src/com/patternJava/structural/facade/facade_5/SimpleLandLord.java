package com.patternJava.structural.facade.facade_5;

import java.util.ArrayList;

public class SimpleLandLord {
    ArrayList<Apartment> listOfApartments = new ArrayList<>();

    public void collectRent() {
        listOfApartments.forEach(apartment -> {
            apartment.findAddress();
            apartment.contactTenant();
            apartment.collectPayment();
            System.out.println("--------------------------------------");
        });
    }

    public void addApartment(Apartment apartment) {
        listOfApartments.add(apartment);
    }
}