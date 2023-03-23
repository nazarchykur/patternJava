package com.patternJava.behavioral.observer.observer_3;

import java.util.ArrayList;
import java.util.List;

/*
1) визначаємо інтерфейс у якому вказуємо три головні методи:
 - додати підписника
 - видалити підписника
 - сповістити всіх підписників про обновлення стану об'єкта, на який ці підписники підписані
 */
interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// 2) наш об'єкт, за зміною стану якого ми спостерігаємо
// в ньому є його поля, які нас інтересують
// ми додаємо інтерфейс, щоб реалізувати методи для підписників
class MeteoStation implements Observed {
    // поля
    int temperature;
    int pressure;

    // масив підписників
    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // метод зміни стану наших полів, при виклику якого ми викликаємо сповістити всіх підписників про нові зміни
    public void setMeasurement(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        // foreach
//        for (Observer observer : observers) {
//            observer.handleEvent(temperature, pressure);
//        }
        // java 8
        observers.stream().forEach(observer -> observer.handleEvent(temperature, pressure));
    }
}

// 3) інтерфейс підписника, який має один метод щодо прослідкованої події
interface Observer {
    void handleEvent(int temp, int pressure);
}

// 4) реалізуємо конкретного підписника
class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temp, int pressure) {
        System.out.println("Weather changed. The temperature = " + temp + ", pressure = " + pressure);
    }
}

public class ObserverMain {
    public static void main(String[] args) {

        // створюємо наш об'єкт, за станом якого ми споглядаємо.
        MeteoStation meteoStation = new MeteoStation();

        // додаємо одного підписника
        meteoStation.addObserver(new ConsoleObserver());

        // змінюємо стан нашого об'єкта, на якого ми підписані
        meteoStation.setMeasurement(5, 770);

        // виведе в консоль
        // Weather changed. The temperature = 5, pressure = 770

        meteoStation.setMeasurement(10, 765);
        // Weather changed. The temperature = 10, pressure = 765
    }
}
