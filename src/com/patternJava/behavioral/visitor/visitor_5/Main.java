package com.patternJava.behavioral.visitor.visitor_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("John Doe", 100000, 20));
        employees.add(new Engineer("Jane Smith", 75000, 15));
        employees.add(new Engineer("Bob Johnson", 80000, 18));

        SalaryVisitor salaryVisitor = new SalaryVisitor();
        VacationDaysVisitor vacationDaysVisitor = new VacationDaysVisitor();

        for (Employee employee : employees) {
            employee.accept(salaryVisitor);
            employee.accept(vacationDaysVisitor);
        }

        System.out.println("Total salary: " + salaryVisitor.getTotalSalary()); // Total salary: 255000.0
        System.out.println("Total vacation days: " + vacationDaysVisitor.getTotalVacationDays()); // Total vacation days: 53

    }
}

interface Employee {
    void accept(Visitor visitor);
}

class Manager implements Employee {
    private String name;
    private double salary;
    private int vacationDays;

    public Manager(String name, double salary, int vacationDays) {
        this.name = name;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Engineer implements Employee {
    private String name;
    private double salary;
    private int vacationDays;

    public Engineer(String name, double salary, int vacationDays) {
        this.name = name;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Manager manager);
    void visit(Engineer engineer);
}

class SalaryVisitor implements Visitor {
    private double totalSalary = 0;

    public double getTotalSalary() {
        return totalSalary;
    }

    @Override
    public void visit(Manager manager) {
        totalSalary += manager.getSalary();
    }

    @Override
    public void visit(Engineer engineer) {
        totalSalary += engineer.getSalary();
    }
}

class VacationDaysVisitor implements Visitor {
    private int totalVacationDays = 0;

    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    @Override
    public void visit(Manager manager) {
        totalVacationDays += manager.getVacationDays();
    }

    @Override
    public void visit(Engineer engineer) {
        totalVacationDays += engineer.getVacationDays();
    }
}
