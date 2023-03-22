package com.patternJava.structural.flyweight.flyweight_3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
// New thick Red Brush
        Brush redThickBrush1 = BrushFactory.getThickBrush("RED");
        redThickBrush1.draw("Hello!");

        // Red Brush is shared
        Brush redThickBrush2 = BrushFactory.getThickBrush("RED");
        redThickBrush2.draw("Hello There Again !!");

        System.out.println("Hashcode: " + redThickBrush1.hashCode());
        System.out.println("Hashcode: " + redThickBrush2.hashCode());
        System.out.println();

        // New thin Blue Brush
        Brush blueThinBrush1 = BrushFactory.getThinBrush("BLUE"); // created a new  type of pen
        blueThinBrush1.draw("Hello!");

        // Blue Brush is shared
        Brush blueThinBrush2 = BrushFactory.getThinBrush("BLUE"); // created new pen
        blueThinBrush2.draw("Hello There Again!!");

        System.out.println("Hashcode: " + blueThinBrush1.hashCode());
        System.out.println("Hashcode: " + blueThinBrush2.hashCode());
        System.out.println();

        // New MEDIUM Yellow Brush
        Brush yellowThinBrush1 = BrushFactory.getMediumBrush("YELLOW"); // created new pen
        yellowThinBrush1.draw("Hello There !!");

        // Yellow brush is shared
        Brush yellowThinBrush2 = BrushFactory.getMediumBrush("YELLOW"); //created new pen
        yellowThinBrush2.draw("Hello There Again!!");

        System.out.println("Hashcode: " + yellowThinBrush1.hashCode());
        System.out.println("Hashcode: " + yellowThinBrush2.hashCode());
        System.out.println();

    }
}

interface Brush {
    public void setColor(String color);

    public void draw(String content);
}

enum BrushSize {
    THIN,
    MEDIUM,
    THICK
}

class ThickBrush implements Brush {

    final BrushSize brushSize = BrushSize.THICK;

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing '" + content + "' in thick color : " + color);
    }
}

class ThinBrush implements Brush {

    final BrushSize brushSize = BrushSize.THIN;

    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing ‘" + content + "' in thin color : " + color);
    }
}

class MediumBrush implements Brush {

    final BrushSize brushSize = BrushSize.MEDIUM;

    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing '" + content + "' in medium color : " + color);
    }
}

class BrushFactory {

    private static final Map<String, Brush> brushMap = new HashMap<>();

    private BrushFactory() {
        throw new AssertionError("Cannot instantiate the class");
    }
    
    public static Brush getThickBrush(String color) {
        String key = color + "-THICK";
        Brush brush = brushMap.get(key);

        if (brush == null) {
            brush = new ThickBrush();
            brush.setColor(color);

            brushMap.put(key, brush);
        }
        return brush;
    }

    public static Brush getThinBrush(String color) {
        String key = color + "-THIN";
        Brush brush = brushMap.get(key);

        if (brush == null) {
            brush = new ThinBrush();
            brush.setColor(color);

            brushMap.put(key, brush);
        }

        return brush;
    }

    public static Brush getMediumBrush(String color) {
        String key = color + "-MEDIUM";
        Brush brush = brushMap.get(key);

        if (brush == null) {
            brush = new MediumBrush();
            brush.setColor(color);

            brushMap.put(key, brush);
        }

        return brush;
    }
}