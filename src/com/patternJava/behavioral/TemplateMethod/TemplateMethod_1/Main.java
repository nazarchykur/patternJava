package com.patternJava.behavioral.TemplateMethod.TemplateMethod_1;

/*
Step 1: Define the Abstract Class

Define an abstract class that contains the template method, as well as the abstract methods that will be implemented by 
the concrete subclasses.
 */

abstract class AbstractClass {
    public void templateMethod() {
        operation1();
        operation2();
        operation3();
    }

    public abstract void operation1();
    public abstract void operation2();
    public abstract void operation3();
}

/*
Step 2: Implement the Concrete Class

Create a concrete subclass that extends the abstract class and implements the abstract methods.
 */
class ConcreteClass extends AbstractClass {
    @Override
    public void operation1() {
        System.out.println("ConcreteClass.operation1()");
    }

    @Override
    public void operation2() {
        System.out.println("ConcreteClass.operation2()");
    }

    @Override
    public void operation3() {
        System.out.println("ConcreteClass.operation3()");
    }
}

/*
Step 3: Use the Template Method

Create an instance of the concrete class and call the template method.

In summary, the Template Method pattern is a design pattern that defines the skeleton of an algorithm in an abstract class, 
allowing its subclasses to provide concrete implementations for some steps of the algorithm. The Template Method pattern 
is useful for code reuse, promoting consistency and reducing code duplication.
 */
public class Main {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
            /*
                ConcreteClass.operation1()
                ConcreteClass.operation2()
                ConcreteClass.operation3()
             */
    }
}
