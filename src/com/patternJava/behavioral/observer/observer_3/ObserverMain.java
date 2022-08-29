package com.patternJava.behavioral.observer.observer_3;

import java.util.ArrayList;
import java.util.List;

/*
1) визначаємо інтерфейс у якому вказуємо три головні методи:
 - додати підписника
 - видалити підписника
 - сповістити всіх підписників про обновлення стану обєкта, на який ці підписники підписані

 */
interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 2) наш обєкт, за зміном стану якого ми спостерігаємо
// в ньому є його поля, які нас інтересують
// ми добаляємо інтерфейс, щоб реалізувати методи для підписників
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

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
        // java 8
        //observers.stream().forEach(observer -> observer.handleEvent(temperature, pressure));
    }

    // метод зміни стану наших полів, при виклику якого ми викликаємо сповістити всіх підписників про нові зміни
    public void setMeasurement(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }
}

// 3) інтерфейс підписника, який має один метод щодо прослідковуваної події
interface Observer {
    void handleEvent(int temp, int pressure);
}

// 4) реалізуємо конкретного підписника
class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int pressure) {
        System.out.println("Weather changed. The temperature = " + temp + ", pressure = " + pressure);
    }
}

public class ObserverMain {
    public static void main(String[] args) {

        // створюємо наш обєкт, за стоном якого ми споглядамо.
        MeteoStation meteoStation = new MeteoStation();
        
        // добавляємо одного підписника
        meteoStation.addObserver(new ConsoleObserver());
        
        // змінюємо стан нашого обєкта, на якого ми підписані
        meteoStation.setMeasurement(5, 770);
        
        // виведе в консоль
        // Weather changed. The temperature = 5, pressure = 770

        meteoStation.setMeasurement(10, 765);
        // Weather changed. The temperature = 10, pressure = 765
    }
}
