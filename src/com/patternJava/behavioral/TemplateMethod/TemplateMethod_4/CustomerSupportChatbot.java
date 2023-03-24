package com.patternJava.behavioral.TemplateMethod.TemplateMethod_4;

public class CustomerSupportChatbot extends Chatbot {
    @Override
    protected void askQuestion() {
        System.out.println("How can I assist you with your account?");
    }

    @Override
    protected void provideAnswer() {
        System.out.println("You can update your account information by logging in to our website.");
    }

    @Override
    protected void greetUser() {
        System.out.println("Welcome to customer support. How can I assist you?");
    }
}

