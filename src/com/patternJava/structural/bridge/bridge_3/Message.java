package com.patternJava.structural.bridge.bridge_3;

public abstract class Message {
    protected MessageSender messageSender;
    
    protected Message(MessageSender messageSender){
        this.messageSender=messageSender;
    }

    public abstract void send();
}
