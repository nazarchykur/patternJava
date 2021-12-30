package com.patternJava.behavioral.state.state_2;

public class InTransition implements PackageState {
    @Override
    public void updateState(DeliveryContext ctx) {
        System.out.println("Package is in transition !!");
        ctx.setCurrentState(new Delivered());
    }
}
