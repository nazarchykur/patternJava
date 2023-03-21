package com.patternJava.structural.bridge.bridge_3;

public class TextMessageSender implements MessageSender {
    @Override
    public void sendMessage() {
        System.out.println("TextMessageSender: Sending text message...");
    }
}
