package com.patternJava.behavioral.command.command_1;


/*
        ШАБЛОН
        Команда ( Command )

        ============================================================================================
        ЦІЛЬ:
        - інкапсулювання запитів у обєкті.

        ============================================================================================
        ДЛЯ ЧОГО ВИКОРИСТОВУЄТЬСЯ:
        - щоб задавати параметри клієнтів для обробки конкретних запитів, створення черги з цих
          запитів або їхнього контролю і підтримки відміни операції

        ============================================================================================
        ПРИКЛАД ВИКОРИСТАННЯ:
        - параметризація обєктів, які виконують дії;
        - визначати запит, ставити його в чергу або виконувати його в різний час.

        ============================================================================================
*/

public class CommandMain {
    public static void main(String[] args) {
        Database database = new Database();

        Developer developer = new Developer(new InsertCommand(database),
                                            new UpdateCommand(database),
                                            new SelectCommand(database),
                                            new DeleteCommand(database) );

        developer.insertRecord();
        developer.updateRecord();
        developer.selectRecord();
        developer.deleteRecord();


    }
}
