package com.patternJava.behavioral.observer.observer_2;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(Message m);
}

class MessagePublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(Message m) {
        for(Observer o: observers) {
            o.update(m);
        }
    }
}

interface Observer {
    void update(Message m);
}

class MessageSubscriberOne implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}

class MessageSubscriberTwo implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}

class MessageSubscriberThree implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}

class Message {
    final String messageContent;

    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}

public class ObserverMain {
    public static void main(String[] args) {
        Observer s1 = new MessageSubscriberOne();
        Observer s2 = new MessageSubscriberTwo();
        Observer s3 = new MessageSubscriberThree();

        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.attach(s2);

        p.notifyUpdate(new Message("First Message"));   //s1 and s2 will receive the update

        //MessageSubscriberOne :: First Message
        //MessageSubscriberTwo :: First Message
        
        System.out.println("------------------------------------------");

        p.detach(s1);
        p.attach(s3);

        p.notifyUpdate(new Message("Second Message")); //s2 and s3 will receive the update
        
        //MessageSubscriberTwo :: Second Message
        //MessageSubscriberThree :: Second Message
    }
}
