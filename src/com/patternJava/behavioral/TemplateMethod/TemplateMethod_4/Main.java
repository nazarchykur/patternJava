package com.patternJava.behavioral.TemplateMethod.TemplateMethod_4;

public class Main {
    public static void main(String[] args) {
        Chatbot customerSupport = new CustomerSupportChatbot();
        customerSupport.chat();

        Chatbot weather = new WeatherChatbot();
        weather.chat();
        
        /*
            Welcome to customer support. How can I assist you?
            How can I assist you with your account?
            Goodbye! Have a nice day.
            
            Hello! How can I assist you?
            It's currently sunny and 25°C in your area.
            Thank you for using our weather service.
         */
    }
}
