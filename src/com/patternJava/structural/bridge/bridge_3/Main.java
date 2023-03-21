package com.patternJava.structural.bridge.bridge_3;

public class Main {
    public static void main(String[] args) {
        MessageSender textMessageSender = new TextMessageSender();
        Message textMessage = new TextMessage(textMessageSender);
        textMessage.send(); // Using TextMessage => TextMessageSender: Sending text message...

        MessageSender emailMessageSender = new EmailMessageSender();
        Message emailMessage = new TextMessage(emailMessageSender);
        emailMessage.send(); // Using TextMessage => EmailMessageSender: Sending email message...

        Message emailMessage2 = new EmailMessage(new EmailMessageSender());
        emailMessage2.send(); // Using EmailMessage => EmailMessageSender: Sending email message...
    }
}
