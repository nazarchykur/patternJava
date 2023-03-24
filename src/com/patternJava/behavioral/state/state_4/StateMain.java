package com.patternJava.behavioral.state.state_4;

/*

1) і State має два стани : open/close = дві реалізації
2) контекстний клас Door має поле State
   - сеттер для встановлення стану
   - changeState() - переключити на наступний стан
   - move() просто делегує виконання методу стану, який зараз встановлений
   
   

 */
public class StateMain {
    public static void main(String[] args) {
        Door door = new Door();
        State state = new Close();
        door.setState(state);
        door.move();

        for (int i = 0; i < 5; i++) {
            door.changeState();
            door.move();
        }
            /*
            Door close
            Door open
            Door close
            Door open
            Door close
            Door open
             */
    }
}

class Door {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void changeState() {
        if (state instanceof Open) {
            setState(new Close());
        } else if (state instanceof Close) {
            setState(new Open());
        }
    }

    public void move() {
        state.openClose();
    }
}

interface State {
    void openClose();
}

class Open implements State {
    @Override
    public void openClose() {
        System.out.println("Door open");
    }
}

class Close implements State {
    @Override
    public void openClose() {
        System.out.println("Door close");
    }
}