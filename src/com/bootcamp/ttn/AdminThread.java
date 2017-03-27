package com.bootcamp.ttn;

import java.util.Scanner;

public class AdminThread extends Admin implements Runnable {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter admin email : ");
        String name = sc.nextLine();

        System.out.print("Enter admin password : ");
        String password = sc.nextLine();

        new AdminController().authenticateAdmin(name,password);
    }
}
