package com.patternJava.creational.singleton.singleton_1;
/*
шаблон: Одиночка

====================
Ціль:

гарантувати ,що у класу буде тільки один єдиний екземпляр і до нього буде глобальний доступ

==========================
для чого використовується:

для створення єдиного екзепляра конкретного класу

=================================
приклад використання:

    - необхідно тільки один екземпляр конкретного класу, який буде доступний для всіх клієнтів
    - цей єдиний екзепляр повинен наслідуватися шляхом породження піжкласів, при цьому
    клієнти мають можливість працювати з класом-наслідником без модифікації свого коду
* */
public class Singleton {
    public static void main(String[] args) {
        System.out.println("the same class:");
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println("-- end --");

        ProgramLogger.getProgramLogger().addLogInfo("first log ...");
        ProgramLogger.getProgramLogger().addLogInfo("second log ...");
        ProgramLogger.getProgramLogger().addLogInfo("third log ...");

        ProgramLogger.getProgramLogger().showLogFile();

    }
}
