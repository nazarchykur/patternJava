package com.patternJava.behavioral.ChainOfResponsibility.ChainOfResponsibility_1;

public class Main {
    public static void main(String[] args) {
        Chain chain = new Chain();

        //Calling chain of responsibility 
        chain.process(new Number(80));  // PositiveProcessor : 80
        chain.process(new Number(-50)); // NegativeProcessor : -50
        chain.process(new Number(0));   // ZeroProcessor : 0
        chain.process(new Number(33));  // PositiveProcessor : 33
    }
}

/*
    Advantages of Chain of Responsibility Design Pattern 
        > To reduce the coupling degree. Decoupling it will request the sender and receiver.
        > Simplified object. The object does not need to know the chain structure.
        > Enhance flexibility of object assigned duties. By changing the members within the chain or change their order, 
            allow dynamic adding or deleting responsibility.
        > Increase the request processing new class of very convenient.
    
    DisAdvantages of Chain of Responsibility Design Pattern
        > The request must be received not guarantee.
        > The performance of the system will be affected, but also in the code debugging is not easy may cause cycle call.
        > It may not be easy to observe the characteristics of operation, due to debug.
        
 */

class Chain {
    private Processor chain;

    public Chain() {
        chain = new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
    }

    public void process(Number request) {
        chain.process(request);
    }
}

abstract class Processor {
    private Processor nextProcessor;

    protected Processor(Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(Number request) {
        if (nextProcessor != null)
            nextProcessor.process(request);
    }
}

class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

class NegativeProcessor extends Processor {
    public NegativeProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Number request) {
        if (request.getNumber() < 0) {
            System.out.println("NegativeProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
}

class ZeroProcessor extends Processor {
    public ZeroProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Number request) {
        if (request.getNumber() == 0) {
            System.out.println("ZeroProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
}

class PositiveProcessor extends Processor {

    public PositiveProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Number request) {
        if (request.getNumber() > 0) {
            System.out.println("PositiveProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
} 