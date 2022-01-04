package com.patternJava.behavioral.observer.observer_1;

import java.util.ArrayList;
import java.util.List;

// Step 1
//Create Subject class.
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }
    
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
//Step 2
//Create Observer class.
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
//Step 3
//Create concrete observer classes
class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }

}
class HexObserver extends Observer{

    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }

}

//Step 4
//Use Subject and concrete observer objects.
public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        /*
            First state change: 15
            Hex String: F
            Binary String: 1111
         */
        System.out.println("\n ---------------------------------");
        System.out.println("Second state change: 10");
        subject.setState(10);
        /*
            Second state change: 10
            Hex String: A
            Binary String: 1010
         */
    }
}
