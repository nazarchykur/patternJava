package com.patternJava.structural.composite.composite_1;
/*
шаблон Компанувальник ( Composite )

============================================================================================
ціль:
    - скомпанувати обєкти в структуру по типу "дерево", дозволяючи клієнтам однозначно трактувати
      як окремі так і складові частини

============================================================================================
для чого використовується:
   - для групування малих компонентів в більші, які в свою чергу можуть стати основою для ще більших структур
============================================================================================
приклад використання:
   - для представлення ієрархії "частина-ціле"
   - ми хочемо, щоб клієнти одним способом трактували як окремі так і складові частини

============================================================================================
 */


public class CompositeEx {
    public static void main(String[] args) {
        Team team = new Team();

        Developer javaDeveloper1 = new JavaDeveloper();
        Developer javaDeveloper2 = new JavaDeveloper();
        Developer phpDeveloper = new PhpDeveloper();

        team.addDeveloper(javaDeveloper1);
        team.addDeveloper(javaDeveloper2);
        team.addDeveloper(phpDeveloper);

        team.createProject();
    }
}
