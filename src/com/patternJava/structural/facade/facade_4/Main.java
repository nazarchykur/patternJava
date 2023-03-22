package com.patternJava.structural.facade.facade_4;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CustomerServiceFacade customerServiceFacade = new CustomerServiceFacade();
        String orderNum = customerServiceFacade.placeOrder("shirt", 2, 100, "1234567890123456");
        System.out.println("Order Num = " + orderNum);
        /*
            The product is available
            Created an order for shirt x 2 for price : 100
            Order [6ff40a5c-a4f4-4891-b03b-3557b1565967] confirmed..!
            Product [shirt] is reduced by [2]
            Order Num = 6ff40a5c-a4f4-4891-b03b-3557b1565967
         */

        String orderNum2 = customerServiceFacade.placeOrder("book", 1, 50, "1234567890123456");
        System.out.println("Order Num = " + orderNum2);
        /*
            The product is not available
                Exception in thread "main" java.lang.RuntimeException: Stock Not available
         */
    }
}


// PaymentService
//    For this dummy service, We are checking if the card is 16 digits long. This service will be used by our facade pattern.
class PaymentService {

    public boolean takePayment(String cardDetails) {
        return cardDetails.length() == 16;
    }
}

// Stock Service
//  This service returns true if the product in question contains the letter “s”. For example, “shirt” and “shoe” would 
//  result in true, but “tie” would result in false.
class StockService {

    public boolean isAvailable(String product, int count) {
        if (product.contains("s")) {
            System.out.println("The product is available");
            return true;
        }
        System.out.println("The product is not available");
        return false;
    }

    public void adjustStock(String product, int count) {
        System.out.println("Product [" + product + "] is reduced by [" + count + "]");
    }
}

class OrderService {

    public String createOrder(String product, int price, int count) {
        System.out.println("Created an order for " + product + " x " + count + " for price : " + price);
        return UUID.randomUUID().toString();
    }

    public void confirmOrder(String orderNum) {
        System.out.println("Order [" + orderNum + "] confirmed..!");
    }
}

// Facade Class
//  Now that we have all classes, lets write our facade. As we understand already, facade is supposed to be a simple and 
//  beautiful API. It is supposed to hide all the internal logics and only provide what is necessary for the client.
class CustomerServiceFacade {

    private final OrderService orderService = new OrderService();
    private final PaymentService paymentService = new PaymentService();
    private final StockService stockService = new StockService();

    String placeOrder(String product, int count, int price, String cardDetails) {
        boolean stockAvailable = stockService.isAvailable(product, count);
        String orderNum;
        if (stockAvailable) {
            orderNum = orderService.createOrder(product, price, count);
        } else {
            throw new RuntimeException("Stock Not available");
        }
        boolean success = paymentService.takePayment(cardDetails);
        if (success) {
            orderService.confirmOrder(orderNum);
            stockService.adjustStock(product, count);
        } else {
            throw new RuntimeException("Payment Failed");
        }
        return orderNum;
    }
}