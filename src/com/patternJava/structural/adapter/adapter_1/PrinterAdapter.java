package com.patternJava.structural.adapter.adapter_1;

import java.util.List;

public class PrinterAdapter implements PageListPrinter {
    // використовуємо чуже АПІ через композицію
    private final Printer printer = new Printer();

    // в нас в програмі є наш інтерфейс, який має метод, який читає масив рядків
    // так як Printer читає тільки один текст
    // то ми у своєму методі через цикл використовуємо його
    @Override
    public void print(List<String> list) {
        for (String text: list) {
            printer.print(text);
        }
    }
}
