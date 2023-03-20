package com.patternJava.behavioral.visitor.visitor_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Visitor : This is an interface or an abstract class used to declare the visit operations for all the types of visitable classes.

ConcreteVisitor : For each type of visitor all the visit methods, declared in abstract visitor, must be implemented. 
                  Each Visitor will be responsible for different operations.

Visitable : This is an interface which declares the accept operation. This is the entry point which enables an 
            object to be “visited” by the visitor object.
            
ConcreteVisitable : These classes implement the Visitable interface or class and defines the accept operation. 
                    The visitor object is passed to this object using the accept operation.
                    
                    
 ------------------
 Visitor pattern is good fit for these types of problems where you want to introduce a new operation to hierarchy of 
 objects, without changing its structure or modifying them. In this solution, we will implement double dispatch 
 technique by introducing two methods i.e. accept() and visit() methods.
                    

 */
interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}

class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int cost, String isbn) {
        this.price = cost;
        this.isbnNumber = isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int wt, String nm) {
        this.pricePerKg = priceKg;
        this.weight = wt;
        this.name = nm;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}

interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = 0;
        //apply 5$ discount if book price is greater than 50
        if (book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        } else
            cost = book.getPrice();

        System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
        
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        
        return cost;
    }

}

public class VisitorMain {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book(20, "1234"),
                new Book(100, "5678"), 
                new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
        
        /*
            Book ISBN::1234 cost =20
            Book ISBN::5678 cost =95
            Banana cost = 20
            Apple cost = 25
            Total Cost = 160
         */
    }

    private static int calculatePrice(ItemElement[] items){
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items){
            sum = sum + item.accept(visitor);
        }
        
        return sum;
    }
}