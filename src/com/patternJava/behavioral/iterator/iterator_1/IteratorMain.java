package com.patternJava.behavioral.iterator.iterator_1;


/*
        ШАБЛОН
        Команда ( Iterator )

        ============================================================================================
        ЦІЛЬ:
        - отримання послідовного доступу до всіх елементів обєкта.

        ============================================================================================
        ДЛЯ ЧОГО ВИКОРИСТОВУЄТЬСЯ:
        - для отримання послідовного доступу до всіх елементів складового обєкта,
          скриваючи його внутрішнє уявлення

        ============================================================================================
        ПРИКЛАД ВИКОРИСТАННЯ:
        - різні види обходу складового обєкту;
        - спрощений доступ до складового обєкту.

        ============================================================================================
*/


public class IteratorMain {
    public static void main(String[] args) {

        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "PostgreSQL"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Nazar", skills);
        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("Skills: ");
        
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString());
            if (iterator.hasNext()) {
                System.out.print(", ");
            }

        }
    }
}
