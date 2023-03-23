package com.patternJava.behavioral.ChainOfResponsibility.ChainOfResponsibility_4;

public class Main {
    public static void main(String[] args) {
        ExpenseHandler travelHandler = new TravelExpenseHandler();
        ExpenseHandler foodHandler = new FoodExpenseHandler();
        ExpenseHandler equipmentHandler = new EquipmentExpenseHandler();

        travelHandler.setNextHandler(foodHandler);
        foodHandler.setNextHandler(equipmentHandler);

        ExpenseReport report1 = new ExpenseReport(ExpenseType.TRAVEL, 750);
        travelHandler.approve(report1); // Output: "Travel expense approved by TravelExpenseHandler"

        ExpenseReport report2 = new ExpenseReport(ExpenseType.FOOD, 400);
        travelHandler.approve(report2); // Output: "Food expense approved by FoodExpenseHandler"

        ExpenseReport report3 = new ExpenseReport(ExpenseType.EQUIPMENT, 3000);
        travelHandler.approve(report3); // Output: "Expense not approved"

    }
}

/*
    Advantages of Chain of Responsibility Design Pattern 
        > To reduce the coupling degree. Decoupling it will request the sender and receiver.
        > Simplified object. The object does not need to know the chain structure.
        > Enhance flexibility of object assigned duties. By changing the members within the chain or change their order, 
            allow dynamic adding or deleting responsibility.
        > Increase the request processing new class of very convenient.
    
    DisAdvantages of Chain of Responsibility Design Pattern
        > The request must be received not guarantee.
        > The performance of the system will be affected, but also in the code debugging is not easy may cause cycle call.
        > It may not be easy to observe the characteristics of operation, due to debug.
        
 */

/*
Let's say we have a program that handles requests for reimbursements for different types of expenses (e.g. travel, food, 
equipment). We want to implement a chain of handlers to process these requests in a specific order, where each handler 
can either approve the request or pass it on to the next handler in the chain.

First, we'll define an interface for our handlers:
 */
interface ExpenseHandler {
    boolean approve(ExpenseReport expense);
    void setNextHandler(ExpenseHandler next);
}

/*
This interface requires each handler to have an approve method that takes an ExpenseReport object and returns a boolean 
indicating whether the request was approved. It also requires each handler to have a setNextHandler method that sets 
the next handler in the chain.

Next, we'll implement three concrete handler classes: one for travel expenses, one for food expenses, and one for equipment expenses.
 */
class TravelExpenseHandler implements ExpenseHandler {
    private ExpenseHandler nextHandler;

    @Override
    public boolean approve(ExpenseReport expense) {
        if (expense.getType() == ExpenseType.TRAVEL && expense.getAmount() <= 1000) {
            System.out.println("Travel expense approved by TravelExpenseHandler");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.approve(expense);
        }
        System.out.println("Expense not approved");
        return false;
    }

    @Override
    public void setNextHandler(ExpenseHandler next) {
        nextHandler = next;
    }
}

/*
This handler checks if the expense type is "travel" and if the amount is less than or equal to $1000. If it meets these 
criteria, it approves the expense and prints a message. Otherwise, it passes the request on to the next handler in the chain.

We'll create a similar class for food expenses:
 */

class FoodExpenseHandler implements ExpenseHandler {
    private ExpenseHandler nextHandler;
    @Override
    public boolean approve(ExpenseReport expense) {
        if (expense.getType() == ExpenseType.FOOD && expense.getAmount() <= 500) {
            System.out.println("Food expense approved by FoodExpenseHandler");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.approve(expense);
        }
        System.out.println("Expense not approved");
        return false;
    }
    @Override
    public void setNextHandler(ExpenseHandler next) {
        nextHandler = next;
    }
}

/*
This handler checks if the expense type is "food" and if the amount is less than or equal to $500. If it meets these 
criteria, it approves the expense and prints a message. Otherwise, it passes the request on to the next handler in the chain.

Finally, we'll create a class for equipment expenses:
 */
class EquipmentExpenseHandler implements ExpenseHandler {
    private ExpenseHandler nextHandler;
    @Override
    public boolean approve(ExpenseReport expense) {
        if (expense.getType() == ExpenseType.EQUIPMENT && expense.getAmount() <= 2000) {
            System.out.println("Equipment expense approved by EquipmentExpenseHandler");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.approve(expense);
        }
        System.out.println("Expense not approved");
        return false;
    }
    @Override
    public void setNextHandler(ExpenseHandler next) {
        nextHandler = next;
    }
}

/*
This handler checks if the expense type is "equipment" and if the amount is less than or equal to $2000. If it meets 
these criteria, it approves the expense and prints a message. Otherwise, it passes the request on to the next handler in the chain.
 */

class ExpenseReport {
    private ExpenseType type;
    private double amount;

    public ExpenseReport(ExpenseType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

enum ExpenseType {
    TRAVEL, FOOD, EQUIPMENT
}