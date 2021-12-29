package com.patternJava.behavioral.strategy.strategy_1;

public class Context {
    private Operation operation;

    public Context(Operation operation) {
        this.operation = operation;
    }

    public int executeOperation(int int1, int int2) {
        return operation.doOperation(int1, int2);
    }
}
