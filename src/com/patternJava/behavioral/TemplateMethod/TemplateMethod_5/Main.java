package com.patternJava.behavioral.TemplateMethod.TemplateMethod_5;

public class Main {
    public static void main(String[] args) {
        AbstractHouse brickHouse = new BrickHouse();
        brickHouse.buildHouse();

        AbstractHouse woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
        
        /*
            Building foundation with cement, iron rods, and sand
            Building walls with bricks and cement
            Building roof with tiles
            Adding beautiful garden to the brick house
            Furnishing the brick house
            
            Building foundation with wood and gravel
            Building walls with wood and nails
            Building roof with wooden planks
            Furnishing the wooden house
         */
    }
}
