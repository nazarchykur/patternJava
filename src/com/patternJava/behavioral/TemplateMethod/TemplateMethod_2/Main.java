package com.patternJava.behavioral.TemplateMethod.TemplateMethod_2;

/*
Step 1: Define the Abstract Class

Define an abstract class that contains the template method, as well as the abstract methods that will be implemented by 
the concrete subclasses.
 */
abstract class FoodRecipe {
    public final void cookRecipe() {
        prepareIngredients();
        cook();
        serve();
        System.out.println();
    }

    public abstract void prepareIngredients();
    public abstract void cook();
    public abstract void serve();
}

/*
Step 2: Implement the Concrete Class

Create a concrete subclass that extends the abstract class and implements the abstract methods.
 */
class SpaghettiRecipe extends FoodRecipe {
    @Override
    public void prepareIngredients() {
        System.out.println("SpaghettiRecipe: Preparing spaghetti and tomato sauce ingredients.");
    }

    @Override
    public void cook() {
        System.out.println("SpaghettiRecipe: Cooking spaghetti and tomato sauce.");
    }

    @Override
    public void serve() {
        System.out.println("SpaghettiRecipe: Serving the spaghetti and tomato sauce.");
    }
}

class PancakeRecipe extends FoodRecipe {
    @Override
    public void prepareIngredients() {
        System.out.println("PancakeRecipe: Preparing pancake batter and toppings.");
    }

    @Override
    public void cook() {
        System.out.println("PancakeRecipe: Cooking pancakes on a griddle.");
    }

    @Override
    public void serve() {
        System.out.println("PancakeRecipe: Serving pancakes with toppings.");
    }
}

/*
Step 3: Use the Template Method

Here's an example of how we can use both SpaghettiRecipe and PancakeRecipe in the main method:
 */
public class Main {
    public static void main(String[] args) {
        FoodRecipe spaghettiRecipe = new SpaghettiRecipe();
        spaghettiRecipe.cookRecipe();

        FoodRecipe pancakeRecipe = new PancakeRecipe();
        pancakeRecipe.cookRecipe();
        
        /*
            SpaghettiRecipe: Preparing spaghetti and tomato sauce ingredients.
            SpaghettiRecipe: Cooking spaghetti and tomato sauce.
            SpaghettiRecipe: Serving the spaghetti and tomato sauce.
            
            PancakeRecipe: Preparing pancake batter and toppings.
            PancakeRecipe: Cooking pancakes on a griddle.
            PancakeRecipe: Serving pancakes with toppings.
         */
    }
}
