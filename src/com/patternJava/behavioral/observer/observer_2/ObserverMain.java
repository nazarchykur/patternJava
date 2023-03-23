package com.patternJava.behavioral.observer.observer_2;

import java.util.ArrayList;
import java.util.List;


public class ObserverMain {
    public static void main(String[] args) {
        Blog blog = new Blog();
        Reader reader1 = new Reader("Alice");
        Reader reader2 = new Reader("Bob");
        Reader reader3 = new Reader("Charlie");

        blog.subscribe(reader1);
        blog.subscribe(reader2);
        blog.subscribe(reader3);

        blog.postMessage("Hello world!");

        blog.unsubscribe(reader2);

        blog.postMessage("How are you doing?");

        blog.subscribe(reader2);

        blog.postMessage("Just a quick update.");
    }
}

// Subject interface
interface Publisher {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscribers(String message);
}

// Observer interface
interface Subscriber {
    void update(String message);
}

// Concrete implementation of the Subject interface
class Blog implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String message;

    public void postMessage(String message) {
        this.message = message;
        notifySubscribers(message);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

// Concrete implementation of the Observer interface
class Reader implements Subscriber {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received a new message: " + message);
    }
}
