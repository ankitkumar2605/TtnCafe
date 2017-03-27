package com.bootcamp.ttn;

import java.util.Scanner;

public class EmployeeThread extends Employee implements Runnable {
    EmployeeController employeeController;
    public EmployeeThread(EmployeeController employeeController){
        this.employeeController = employeeController;
    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user email : ");
        String name = sc.nextLine();

        System.out.print("Enter user password : ");
        String password = sc.nextLine();

        employeeController.authenticateEmployee(name, password);
    }
}
