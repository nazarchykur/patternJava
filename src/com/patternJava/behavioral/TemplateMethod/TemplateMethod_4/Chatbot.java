package com.patternJava.behavioral.TemplateMethod.TemplateMethod_4;

public abstract class Chatbot {
    // Template method
    public final void chat() {
        greetUser();
        if (isHuman()) {
            askQuestion();
        } else {
            provideAnswer();
        }
        sayGoodbye();
    }

    protected abstract void askQuestion();

    protected abstract void provideAnswer();

    protected void greetUser() {
        System.out.println("Hello! How can I assist you?");
    }

    protected boolean isHuman() {
        return true;
    }

    protected void sayGoodbye() {
        System.out.println("Goodbye! Have a nice day.\n");
    }
}

