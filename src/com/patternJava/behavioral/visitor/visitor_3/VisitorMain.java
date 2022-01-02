package com.patternJava.behavioral.visitor.visitor_3;


// 1) визначаємо інтерефейс, який буде представляти всі елементи структури
interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

// 2) конкретна реалізація = елемент 
// черз метод accept(Visitor visitor) передаємо візітору сику на себе 
class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

// клас, який представляє сукупність цих всіх елеменів
class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart part : parts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

// 3) визначаємо інтерфейс візітора, який має перелік перегруженого метода для роботи з кожним типом елемента
interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

// 4) конкретний візітор
//      кожен метод якого працює з конкретним елементом
class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}

public class VisitorMain {

        public static void main(String[] args) {
            
            // 5) отже нашому класу, якмй представляє сукупність елементів передаємо конкретного візітора
            //     щоб той виконав необхідні дії з кожним елементом

            ComputerPartDisplayVisitor displayVisitor = new ComputerPartDisplayVisitor();
            
            ComputerPart computer = new Computer();
            computer.accept(displayVisitor);
            // 6) виведе в консоль 
            /*
                Displaying Mouse.
                Displaying Keyboard.
                Displaying Monitor.
                Displaying Computer.
             */
        }


}