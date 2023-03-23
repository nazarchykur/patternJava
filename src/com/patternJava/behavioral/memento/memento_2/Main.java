package com.patternJava.behavioral.memento.memento_2;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.setText("Hello, world!");
        history.save(editor);

        editor.setText("Goodbye, world!");
        history.save(editor);

        editor.setText("Hello again, world!");
        System.out.println("Current text: " + editor.getText()); // Current text: Hello again, world!

        history.undo(editor);
        System.out.println("Undone text: " + editor.getText()); // Undone text: Goodbye, world!

        history.undo(editor);
        System.out.println("Undone text: " + editor.getText()); // Undone text: Hello, world!
    }
}

// Originator class
class TextEditor {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento memento) {
        this.text = memento.getText();
    }
}

// Memento class
class TextEditorMemento {
    private String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Caretaker class
class TextEditorHistory {
    private Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            TextEditorMemento memento = history.pop();
            editor.restore(memento);
        }
    }
}