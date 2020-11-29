package com.patternJava.creational.singleton.singleton_4;
/*
створюємо ОДИНОЧКУ
 - має глобальний доступ
 - так як ми створили статичний метод і ініціаліховуємо статичну змінну, то ІНІЦІАЛІЗАЦІЯ відбудеться зразу
 = так званий EAGER
 */
public class Singleton {
    public static void main(String[] args) {
        System.out.println(SingletonClass4.getINSTANCE());
        System.out.println(SingletonClass4.getINSTANCE());

    }
}

class SingletonClass4 {
    private static final SingletonClass4 INSTANCE = new SingletonClass4();
    private SingletonClass4() {}

    public static SingletonClass4 getINSTANCE() {
        return INSTANCE;
    }
}