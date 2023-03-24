package com.patternJava.behavioral.TemplateMethod.TemplateMethod_4;

public class WeatherChatbot extends Chatbot {
    @Override
    protected void askQuestion() {
        System.out.println("What's your location?");
    }

    @Override
    protected void provideAnswer() {
        System.out.println("It's currently sunny and 25°C in your area.");
    }

    @Override
    protected boolean isHuman() {
        return false;
    }

    @Override
    protected void sayGoodbye() {
        System.out.println("Thank you for using our weather service.");
    }
}

