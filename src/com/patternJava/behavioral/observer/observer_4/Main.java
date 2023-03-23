package com.patternJava.behavioral.observer.observer_4;

import java.util.ArrayList;
import java.util.List;

/*
    In this example, ConcreteSubject is the class that represents the observable (subject) and maintains its state. 
    It has methods to add and remove observers (addObserver and removeObserver) and to notify all registered observers 
    (notifyObservers) when its state changes.
    
    The ConcreteObserver class represents an observer and has a reference to the ConcreteSubject it observes. 
    When the update method of an observer is called, it prints out the current state of the subject.
    
    In the main method, we create a ConcreteSubject object and two ConcreteObserver objects. We register both observers 
    with the subject by calling addObserver on the subject object. Then, we change the state of the subject object, 
    which triggers a call to the update method of each registered observer. Finally, we remove one of the observers and 
    change the state of the subject again to show that the removed observer is no longer notified.
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(1);
        subject.removeObserver(observer2);
        subject.setState(2);
    }
}

// Observable (Subject) interface
interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// Observer interface
interface Observer {
    void update();
}

// Concrete implementation of the Observable interface
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public String toString() {
        return "ConcreteSubject{" +
                "state=" + state +
                '}';
    }
}

// Concrete implementation of the Observer interface
class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Observer: " + this + " updated with state " + subject.getState());
    }

    @Override
    public String toString() {
        return "ConcreteObserver{" +
                "subject=" + subject +
                '}';
    }
}