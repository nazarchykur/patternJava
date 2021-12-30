package com.patternJava.behavioral.state.state_2;

public class Delivered implements PackageState {
    @Override
    public void updateState(DeliveryContext ctx) {
        System.out.println("Package is delivered!!");
    }
}
