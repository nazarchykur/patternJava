package com.patternJava.behavioral.state.state_2;

public class Acknowledged implements PackageState {
    @Override
    public void updateState(DeliveryContext ctx) {
        System.out.println("Package is acknowledged !!");
        ctx.setCurrentState(new Shipped());
    }
}
