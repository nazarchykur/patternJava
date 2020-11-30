package com.patternJava.structural.decorator.decorator_1;

/*
        ШАБЛОН
        Декоратор ( Decorator )

        ============================================================================================
        ЦІЛЬ:
        - динамічне добавлення нових обовязків для обєкту

        ============================================================================================
        ДЛЯ ЧОГО ВИКОРИСТОВУЄТЬСЯ:
        - використовується в якості альтернативи породження відкласів для розширення функціональністі

        ============================================================================================
        ПРИКЛАД ВИКОРИСТАННЯ:
        - динамічне і зрозумуле для клієнтів добавлення обовязків до обєктів;
        - реалізація обовязків, які можуть бути зняті з обєкту;
        - розширення класу шляхом породження підкласів неможливе по якимось причинам.

        ============================================================================================
*/

public class DecoratorMain {
    public static void main(String[] args) {
        Developer developer = new JavaDeveloper();
        System.out.println(developer.makeJob());

        // with decorator
        Developer developer1 = new SeniorJavaDeveloper(new JavaDeveloper());
        System.out.println(developer1.makeJob());

        Developer developer2 = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()) );
        System.out.println(developer2.makeJob());
    }


}
