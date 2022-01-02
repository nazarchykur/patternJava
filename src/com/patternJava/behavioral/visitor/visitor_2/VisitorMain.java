package com.patternJava.behavioral.visitor.visitor_2;

import java.util.Arrays;
import java.util.List;

/* 
1) є інтерфейс Element з методом, який приймає візітора,

     а кожен конкретний елемент має перезаписє метод accept(), передаючи силку на себе візітору
 
         public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    
 тобто ми просто кожному кнкретному елементу через метод accept() передаємо самого себе, щоб конкретний візітор 
 робив відповідні операції
 
 тому у візітора є перегружений метод visit(), який приймає кожен конкретний елемент
    void visit(EngineElement engine);
    void visit(BodyElement body);
    
2) Visitor#visit(ConcreteElement)
кількість цього перегруженого методу = кількості елементів структури, щоб мати можливість здійснювати операцію над 
кожним типом елемента структури

        interface Visitor {
            void visit(EngineElement engine);
            void visit(BodyElement body);

дві реалізації візітора:
 - DoRepairCarVisitor - це зроблений огляд і ремонт машини
 - PrintResultVisitor - друк інфо про зроблену роботу над машиною      

3) в даному випадку клас Car представляє структуру елементів   

і через метод 
  public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }    
     ми здійснюємо відповідні операції з кожним елементом = кожен тип  - це своя операція візітора
     
     тому передаючи рідного візітора, ми маємо різні операції над елементами
    
 */

public class VisitorMain {
    public static void main(String[] args) {
        Car car = new Car();

        Visitor reviewCar = new DoRepairCarVisitor();
        Visitor printInfo = new PrintResultVisitor();

        System.out.println("===== check car ======");
        car.accept(reviewCar);
        /*
            Review engine...
            review body of car...
            review state of car...
         */
        
        System.out.println("===== print result ======");
        car.accept(printInfo);
        /*
            Print info about review engine...
            Print info about review body of car...
            Print info about car...
         */
    }
    
}



interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Car implements Element {
    private List<Element> elements;

    public Car() {
        this.elements = Arrays.asList(new EngineElement(), new BodyElement());
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(Car car);
}

class DoRepairCarVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Review engine...");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("review body of car...");
    }

    @Override
    public void visit(Car car) {
        System.out.println("review state of car...");
    }
}

class PrintResultVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Print info about review engine...");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Print info about review body of car...");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Print info about car...");
    }
}