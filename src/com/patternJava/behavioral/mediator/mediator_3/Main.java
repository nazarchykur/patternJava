package com.patternJava.behavioral.mediator.mediator_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightControlMediator mediator = new FlightControlMediatorImpl();

        Airplane airplane1 = new Airplane("Boeing 747", mediator);
        Airplane airplane2 = new Airplane("Airbus A380", mediator);

        airplane1.sendMessage("Hello, this is Boeing 747.");
        airplane2.sendMessage("Hello, this is Airbus A380.");
    }
}
interface FlightControlMediator {
    void registerFlight(Airplane airplane);
    void sendMessage(String message, Airplane sender);
}

class FlightControlMediatorImpl implements FlightControlMediator {
    private List<Airplane> airplanes = new ArrayList<>();

    @Override
    public void registerFlight(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void sendMessage(String message, Airplane sender) {
        for (Airplane airplane : airplanes) {
            // Don't send the message back to the sender
            if (airplane != sender) {
                airplane.receiveMessage(message);
            }
        }
    }
}

class Airplane {
    private String name;
    private FlightControlMediator mediator;

    public Airplane(String name, FlightControlMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.registerFlight(this);
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}