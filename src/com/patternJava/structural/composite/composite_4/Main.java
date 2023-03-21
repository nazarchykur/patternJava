package com.patternJava.structural.composite.composite_4;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        CompositeBox compositeBox = new CompositeBox(new VideoGame("vg", 100));

        CompositeBox compositeBox3 = new CompositeBox(
                new CompositeBox(new Book("book 1", 20), new Book("book 2", 30)),
                new VideoGame("vg 2", 50),
                new VideoGame("vg 3", 70));

        
        deliveryService.setupOrder(compositeBox, compositeBox3);

        double totalPrice = deliveryService.calculateOrderPrice();

        System.out.println("totalPrice = " + totalPrice); // totalPrice = 270.0
    }
}
