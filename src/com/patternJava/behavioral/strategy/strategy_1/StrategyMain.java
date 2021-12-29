package com.patternJava.behavioral.strategy.strategy_1;

/*
Advantages:

1) A family of algorithms can be defined as a class hierarchy and can be used interchangeably to alter 
   application behavior without changing its architecture.
2) By encapsulating the algorithm separately, new algorithms complying with the same interface can be easily introduced.
3) The application can switch strategies at run-time.
4) Strategy enables the clients to choose the required algorithm, without using a “switch” statement or a series 
   of “if-else” statements.
5) Data structures used for implementing the algorithm are completely encapsulated in Strategy classes. 
   Therefore, the implementation of an algorithm can be changed without affecting the Context class.

*/
public class StrategyMain {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("context.executeOperation(5, 3) = " + context.executeOperation(5, 3)); // context.executeOperation(5, 3) = 8

        context = new Context(new OperationSubstract());
        System.out.println("context.executeOperation(5, 3) = " + context.executeOperation(5, 3)); // context.executeOperation(5, 3) = 2
    }
}
