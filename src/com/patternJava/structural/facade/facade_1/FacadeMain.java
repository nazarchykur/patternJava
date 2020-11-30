package com.patternJava.structural.facade.facade_1;

/*
        ШАБЛОН
        Декоратор ( Facade )

        ============================================================================================
        ЦІЛЬ:
        - надати уніфікований інтерфейс замість кількох інтерфейсів підсистеми

        ============================================================================================
        ДЛЯ ЧОГО ВИКОРИСТОВУЄТЬСЯ:
        - використовується для визначення інтерфеусу високого рівня, який спрощує використання підсистеми

        ============================================================================================
        ПРИКЛАД ВИКОРИСТАННЯ:
        - ізолювання клієнтів від компонентів підсистеми спрощує роботу з нею;
        - необхідність ослаблення звязаності підсистеми з клієнтами.

        ============================================================================================
*/
public class FacadeMain {
    public static void main(String[] args) {
//        Job job = new Job();
//        job.doJob();
//        BugTracker bugTracker = new BugTracker();
//        bugTracker.startSprint();
//        Developer developer = new Developer();
//        developer.doJobBeforeDeadline(bugTracker);
//        bugTracker.finishSprint();
//        developer.doJobBeforeDeadline(bugTracker);
        WorkflowFacade workflow = new WorkflowFacade();
        workflow.solveProblems();
    }
}
