package com.patternJava.behavioral.memento.memento_3;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        GameState state = new GameState();
        GameStateHistory history = new GameStateHistory();

        state.setLevel(1);
        state.setScore(100);
        history.save(state);

        state.setLevel(2);
        state.setScore(200);
        history.save(state);

        state.setLevel(3);
        state.setScore(300);
        System.out.println("Current state: " + state); // Current state: Level: 3, Score: 300

        history.undo(state);
        System.out.println("Undone state: " + state); // Undone state: Level: 2, Score: 200

        history.undo(state);
        System.out.println("Undone state: " + state); // Undone state: Level: 1, Score: 100
    }
}

// Originator class
class GameState {
    private int level;
    private int score;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameStateMemento save() {
        return new GameStateMemento(level, score);
    }

    public void restore(GameStateMemento memento) {
        this.level = memento.getLevel();
        this.score = memento.getScore();
    }

    @Override
    public String toString() {
        return "Level: " + level + ", Score: " + score;
    }
}

// Memento class
class GameStateMemento {
    private int level;
    private int score;

    public GameStateMemento(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}

// Caretaker class
class GameStateHistory {
    private Stack<GameStateMemento> history = new Stack<>();

    public void save(GameState state) {
        history.push(state.save());
    }

    public void undo(GameState state) {
        if (!history.isEmpty()) {
            GameStateMemento memento = history.pop();
            state.restore(memento);
        }
    }
}