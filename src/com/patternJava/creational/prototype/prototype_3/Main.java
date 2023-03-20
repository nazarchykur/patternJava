package com.patternJava.creational.prototype.prototype_3;

public class Main {
    public static void main(String[] args) {
        /* Cheesecake preparation */
        CheeseCake cake1 = new CheeseCake();
        cake1.addSugar("100g");
        cake1.addButter("200g");
        cake1.addCheese("Mocarella");
        System.out.println("cake1 = " + cake1);
        // cake1 = CheeseCake{sugar='100g', butter='200g', cheese='Mocarella', name='null'}


        /* Order with custom name */
        CheeseCake cake2 = (CheeseCake) cake1.prepareCake();
        cake2.setName("Mjey");
        System.out.println("cake2 = " + cake2);
        // cake2 = CheeseCake{sugar='100g', butter='200g', cheese='Mocarella', name='Mjey'}


        /* Order with custom name and customized cheese */
        CheeseCake cake3 = (CheeseCake) cake1.prepareCake();
        cake3.addCheese("Extra Cheese");
        cake3.setName("Donnie");
        System.out.println("cake3 = " + cake3);
        // cake3 = CheeseCake{sugar='100g', butter='200g', cheese='Extra Cheese', name='Donnie'}
    }
}