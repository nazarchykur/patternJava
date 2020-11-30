package com.patternJava.structural.decorator.decorator_2;

public class DecoratorMain {
    public static void main(String[] args) {

        PrinterInterface printer = new Printer("hello");
        printer.print();
        System.out.println();

        PrinterInterface printer1 = new QuotesDecorator(new Printer("hello 1"));
        printer1.print();
        System.out.println();

        PrinterInterface printer2 = new BracketsDecorator(new Printer("hello 2"));
        printer2.print();
        System.out.println();

        PrinterInterface printer3 = new BracketsDecorator(new QuotesDecorator(new Printer("hi")));
        printer3.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface{
    PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}
class BracketsDecorator implements PrinterInterface{
    PrinterInterface component;

    public BracketsDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
        System.out.print("]");
    }
}