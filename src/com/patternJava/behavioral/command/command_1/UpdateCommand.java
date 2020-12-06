package com.patternJava.behavioral.command.command_1;

public class UpdateCommand implements Command {

    Database database;

    public UpdateCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.update();

    }
}
