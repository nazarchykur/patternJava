package com.patternJava.creational.singleton.singleton_3;

/*
творюємо ОДИНОЧКУ
        - має глобальний доступ
        - перше перевіряємо чи створений екземпляр чи ні і тільки потім при першій потребі буде створений
        = так званий LAZY
*/

public class Singleton {
    public static void main(String[] args) {
//        SingletonClass singletonClass = SingletonClass.getInstance();
//        System.out.println(singletonClass);
        System.out.println("singletonClass = " + SingletonClass3.getInstance());
        System.out.println("singletonClass = " + SingletonClass3.getInstance());
        System.out.println("singletonClass = " + SingletonClass3.getInstance());
    }

}

class SingletonClass3 {
    private static SingletonClass3 instance = null;
    private SingletonClass3() { }

    public static SingletonClass3 getInstance() {
        if (instance == null) {
            synchronized (SingletonClass3.class) {
                if (instance == null) {
                    instance = new SingletonClass3();
                }
            }
        }
        return instance;
    }

}