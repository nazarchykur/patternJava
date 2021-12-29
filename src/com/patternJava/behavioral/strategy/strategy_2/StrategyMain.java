package com.patternJava.behavioral.strategy.strategy_2;


/*

1) отже у контекстному класі через композицію є поле = інтерфейс стратегії = 
 - імплементації незалежні один від одного
 - ці імплементації використовуються щоб зробити ТУ САМУ дію (сортування, оплата, маршрут ....)
 
 2) у клієнському коді ми можемо передавити у контекстний клас різні стратегії, щоб виконати дію, а
    потім при потребі можемо засетати іншу стратегію  і.т.д
    
 */

public class StrategyMain {
    public static void main(String[] args) {
        Developer developer = new Developer();

        developer.setActivity(new Sleeping());
        developer.executeActivity(); // Sleeping...

        developer.setActivity(new Codding());
        developer.executeActivity(); // Codding...

        developer.setActivity(new Reading());
        developer.executeActivity(); // Reading...
    }
}
