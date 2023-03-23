package com.patternJava.behavioral.mediator.mediator_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FormMediator mediator = new FormMediator();
        Button button = new Button(mediator);
        TextField textField = new TextField(mediator);
        
        mediator.addComponent(button);
        mediator.addComponent(textField);
        
        button.click(); // TextField received event: click
        textField.input("Hello, world!"); // Button received event: input: Hello, world!
    }
}
interface Mediator {
    void notify(Component sender, String event);
}

abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String event) {
        mediator.notify(this, event);
    }

    public abstract void receive(String event);
}

class Button extends Component {
    public Button(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String event) {
        System.out.println("Button received event: " + event);
    }

    public void click() {
        send("click");
    }
}

class TextField extends Component {
    public TextField(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String event) {
        System.out.println("TextField received event: " + event);
    }

    public void input(String text) {
        send("input: " + text);
    }
}

class FormMediator implements Mediator {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void notify(Component sender, String event) {
        for (Component component : components) {
            if (component != sender) {
                component.receive(event);
            }
        }
    }
}