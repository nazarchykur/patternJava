package com.patternJava.creational.singleton.singleton_2;

/*
    - створення обєкта в єдиному екземплярі
    - Глобальний доступ (зазвичай через статичний метод або змінну)
    - можна керувати кількістю екземплярів обєкта, який можна створити
    - єдина точка доступу
    - небезпека частого використання
* */
public class Singleton {
    public static void main(String[] args) {
        TestSingleton.getInstance().print();
        TestSingleton.getInstance().print();
        TestSingleton.getInstance().print();

    }
}
