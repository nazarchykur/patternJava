package com.patternJava.behavioral.state.state_1;

public class StateMain {
    public static void main(String[] args) {
        Context context = new Context();

        State state = new StartState();
        state.doAction(context);

        System.out.println("context.getState().toString() = " + context.getState().toString()); // StartState{}

        state = new StopState();
        state.doAction(context);

        System.out.println("context.getState().toString() = " + context.getState().toString()); // StopState{}
    }
}
