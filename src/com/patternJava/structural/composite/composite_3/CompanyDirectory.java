package com.patternJava.structural.composite.composite_3;

import java.util.ArrayList;
import java.util.List;

public class CompanyDirectory implements Employee {

    private List<Employee> employeeList = new ArrayList<>();
    
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }
    

    @Override
    public void showEmployeeDetails() {
        // using enhanced for loop
        /*
            for(Employee emp : employeeList) {
                emp.showEmployeeDetails();
            }
         */
        
        // using Stream API
        employeeList.forEach(Employee::showEmployeeDetails);
    }
}
