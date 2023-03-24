package com.patternJava.behavioral.strategy.strategy_3;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy("1234567890123456", "12/23", "123");
        PaymentContext context = new PaymentContext(creditCardStrategy);
        context.pay(100); // 100.0 paid with credit card.

        PaymentStrategy paypalStrategy = new PayPalPaymentStrategy("myemail@example.com", "mypassword");
        context.setPaymentStrategy(paypalStrategy);
        context.pay(200); // 200.0 paid using PayPal.
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

class PayPalPaymentStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPaymentStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}