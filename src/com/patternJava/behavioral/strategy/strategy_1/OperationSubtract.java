package com.patternJava.behavioral.strategy.strategy_1;

public class OperationSubtract implements Operation {
    @Override
    public int doOperation(int x, int y) {
        return x - y;
    }
}
