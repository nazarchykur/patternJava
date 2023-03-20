package com.patternJava.creational.prototype.prototype_4;

import java.util.HashMap;
import java.util.Map;

public class ColorStore {

    private static Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("red", new RedColor());
        colorMap.put("green", new GreenColor());
    }

    public static Color getColor(String colorName) {
        return (Color) colorMap.get(colorName).clone();
    }
}
