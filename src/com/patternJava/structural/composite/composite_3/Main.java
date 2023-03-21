package com.patternJava.structural.composite.composite_3;

public class Main {
    public static void main(String[] args) {
        Employee dev1 = new Developer(1, "Leo", "Pro Developer");
        Employee dev2 = new Developer(2, "Mikey", "Developer");

        CompanyDirectory devDirectory = new CompanyDirectory();
        devDirectory.addEmployee(dev1);
        devDirectory.addEmployee(dev2);

        Employee man1 = new Manager(3, "MJey", "Manager");
        Employee man2 = new Manager(4, "San", "SEO Manager");

        CompanyDirectory managerDirectory = new CompanyDirectory();
        managerDirectory.addEmployee(man1);
        managerDirectory.addEmployee(man2);
        
        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(devDirectory);
        directory.addEmployee(managerDirectory);

        directory.showEmployeeDetails();
        /*
            id: 1, name:Leo
            id: 2, name:Mikey
            id: 3, name:MJey
            id: 4, name:San
         */
    }
}
