package com.patternJava.structural.bridge.bridge_3;

public class EmailMessage extends Message {
    protected EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send() {
        System.out.print("Using EmailMessage => ");
        messageSender.sendMessage();
    }
}
