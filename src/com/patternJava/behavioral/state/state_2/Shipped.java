package com.patternJava.behavioral.state.state_2;

public class Shipped implements PackageState {
    @Override
    public void updateState(DeliveryContext ctx) {
        System.out.println("Package is shipped !!");
        ctx.setCurrentState(new InTransition());
    }
}
