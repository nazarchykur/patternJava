package com.patternJava.structural.adapter.adapter_1;

/*
  - допомагає двом різним інтерфейсам працювати разом
  - реалізується 2 способами: наслідуванням і  композицією
 */

import java.util.ArrayList;
import java.util.List;

public class AdapterEx {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("text1");
        strings.add("text2");
        strings.add("text3");

        PrinterAdapter printerAdapter = new PrinterAdapter();
        printerAdapter.print(strings);
    }
}
