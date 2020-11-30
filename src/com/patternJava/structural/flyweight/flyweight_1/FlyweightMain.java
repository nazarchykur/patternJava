package com.patternJava.structural.flyweight.flyweight_1;

/*
        ШАБЛОН
        Пристосувальник ( Flyweight )

        ============================================================================================
        ЦІЛЬ:
        - підтримка безлічі малих обєктів

        ============================================================================================
        ДЛЯ ЧОГО ВИКОРИСТОВУЄТЬСЯ:
        - використовує розподіл, щоб підтримувати багато дрібних обєктів

        ============================================================================================
        ПРИКЛАД ВИКОРИСТАННЯ:
        - коли використовується багато обєктів;
        - більшу частину стану обєктів можна винести назовні;
        - наш додаток (Application) не залежить від ідентичності обєктів.

        ============================================================================================
*/

import java.util.ArrayList;
import java.util.List;

public class FlyweightMain {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();
        List<Developer>developers = new ArrayList<>();
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("js"));
        developers.add(developerFactory.getDeveloperBySpeciality("js"));
        developers.add(developerFactory.getDeveloperBySpeciality("js"));

        for (Developer developer : developers){
            developer.writeCode();
        }
    }

}
