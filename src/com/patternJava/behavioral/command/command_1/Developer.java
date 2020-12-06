package com.patternJava.behavioral.command.command_1;

public class Developer {
    Command insert;
    Command update;
    Command select;
    Command delete;

    public Developer(Command insert, Command update, Command select, Command delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    public void insertResord() {
        insert.execute();
    }

    public void updateResord() {
        update.execute();
    }

    public void selectResord() {
        select.execute();
    }

    public void deleteResord() {
        delete.execute();
    }
}
