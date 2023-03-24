package com.patternJava.behavioral.state.state_1;

/*
The State pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state 
changes. This pattern is useful when an object needs to change its behavior based on its current state.

Step 1: Define the State interface
 */
interface State {
    void doAction(Context context);
}

/*
The State interface defines the methods that the concrete state classes should implement. In this case, the doAction method 
is defined, which takes a Context object as a parameter.

Here we have two concrete state classes StartState and StopState which implement the State interface. The doAction method 
is overridden in these classes to provide specific behavior based on their state.

Step 2: Implement Concrete State classes
 */
class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
}

class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
}

/*
Step 3: Define the Context class

The Context class is the class that holds the current state of the object and delegates the state-specific behavior to 
the concrete state classes. In this example, Context has a State object and a doAction method which delegates the behavior 
to the current state object.
 */
class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void doAction() {
        state.doAction(this);
    }
}

/*
Step 4: Use the Context and State classes

Here, we create a Context object and then create two state objects StartState and StopState. We then call the doAction 
method on each of these objects with the Context object as a parameter. This changes the state of the Context object and 
invokes the state-specific behavior.

Finally, we print the current state of the Context object to verify that the state has been changed.

Overall, the State pattern allows objects to alter their behavior based on their internal state. This is achieved by 
defining a set of concrete state classes that implement a common State interface and delegating the state-specific 
behavior to the current state object held by the Context class.

 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());

        startState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
