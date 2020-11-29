package com.patternJava.creational.factory.factory_1;
/*
шаблон: Фабрика

====================
Ціль:

створення інтерфейсу, який створює обєкти. при цьому вибір того який екземпляр створювати залишається
за класами які імплементують даний інтерфейс

==========================
для чого використовується:

для делегування створення екзкмпляра другому класу

=================================
приклад використання:

    - наперед невідомо екземпляри якого класу потрібно буде створювати
    - клас спроектований таким чином, що створювані ним обєкти  мають властивості певного класу
*/
public class Factory {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpec("php");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpec(String spec) {
        if (spec.equals("java")) {
            return new JavaDeveloperFactory();
        } else if (spec.equals("php")) {
            return new PhpDeveloperFactory();
        } else {
            throw new RuntimeException(spec + " is unknown spec");
        }
    }
}
