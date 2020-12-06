package com.patternJava.behavioral.iterator.iterator_2;

public class IteratorMain {
    public static void main(String[] args) {

        /*
        отже ми маємо конкретну колекцію елементів ConcreteAggregate

        1) так як ми плануємо пробігатися по цій колекції, то імплемеуємо Aggregate,
           який поверне нам ітератор через метод getIterator, а саме конкретний наш TaskIterator
        2) ток як ми знаємо, що потрібен ітератор, то створюємо внутрішній клас TaskIterator
           у нашому класі ConcreteAggregate, який імплементує Iterator з двома методами
           (boolean hasNext(); Object next(); )
        3) тепер створюючи клас, який має колекцію елементів, ми створюємо
           Iterator iterator, якому прокидаємо наш ітератор з цієї колекції
           concreteAggregate.getIterator();
           і через цикл while() перевіряємо чи є елемент у масиві, і беремо цей елемент


         */
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        Iterator iterator = concreteAggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println( (String)iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {
    String[] tasks = {"task 1", "task 2", "task 3"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
