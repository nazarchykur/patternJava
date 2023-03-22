package com.patternJava.structural.proxy.proxy_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InternetAccess internetAccess = new ProxyEmployeeInternetAccess("leo");
        internetAccess.grantInternetAccessToEmployees();
        
        // + Internet Access granted for employee: leo
        // - No Internet access granted. Your job level is below 5
    }
}

interface InternetAccess {
    void grantInternetAccessToEmployees();
}

class EmployeeInternetAccess implements InternetAccess {
    private String employeeName;

    public EmployeeInternetAccess(String empName) {
        this.employeeName = empName;
    }

    @Override
    public void grantInternetAccessToEmployees() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }
}

class ProxyEmployeeInternetAccess implements InternetAccess {
    private String employeeName;
    private EmployeeInternetAccess employeeInternetAccess;

    public ProxyEmployeeInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccessToEmployees() {
        int roleId = getRole(employeeName);
        if (roleId > 5) {
            employeeInternetAccess = new EmployeeInternetAccess(employeeName);
            employeeInternetAccess.grantInternetAccessToEmployees();
        } else {
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }

    public int getRole(String empName) {
        //make a DB call to get the employee role and return it.
        return new Random().nextInt(10);
    }
}