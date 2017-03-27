package com.bootcamp.ttn;

import java.util.Scanner;

public class EmployeeThread extends Employee implements Runnable {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user email : ");
        String name = sc.nextLine();

        System.out.print("Enter user password : ");
        String password = sc.nextLine();

        new EmployeeController().authenticateEmployee(name, password);
    }
}
