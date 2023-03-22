package com.patternJava.structural.facade.facade_5;

public class Apartment {
    private final String tenantName;
    private final String address;
    private final int rentPayment;

    public Apartment(String tenantName, String address, int rentPayment) {
        this.tenantName = tenantName;
        this.address = address;
        this.rentPayment = rentPayment;
    }

    public void contactTenant() {
        System.out.println(tenantName + " has been contacted.");
    }

    public void collectPayment() {
        System.out.println(rentPayment + "$ has been collected in rent payment.");
    }

    public void findAddress() {
        System.out.println("The address of this apartment is " + address);
    }
}
