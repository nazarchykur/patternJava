package com.patternJava.structural.bridge.bridge_3;

public class TextMessage extends Message {
    protected TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send() {
        System.out.print("Using TextMessage => ");
        messageSender.sendMessage();
    }
}
