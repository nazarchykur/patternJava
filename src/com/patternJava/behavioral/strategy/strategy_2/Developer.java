package com.patternJava.behavioral.strategy.strategy_2;

public class Developer {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeActivity() {
        activity.doIt();
    }
}
