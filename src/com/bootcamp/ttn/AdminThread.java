package com.bootcamp.ttn;

import java.util.Scanner;

public class AdminThread extends Admin implements Runnable {
    AdminController adminController;
    public AdminThread(AdminController adminController){
        this.adminController = adminController;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user email : ");
        String name = sc.nextLine();

        System.out.print("Enter user password : ");
        String password = sc.nextLine();

        adminController.authenticateAdmin(name, password);
    }
}
