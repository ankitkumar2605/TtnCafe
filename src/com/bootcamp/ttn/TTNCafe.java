package com.bootcamp.ttn;

import java.util.Scanner;

public class TTNCafe {
    public static void main(String[] args) {
        User admin = new Admin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user name : ");
        String name = sc.nextLine();

        System.out.print("Enter user password : ");
        String password = sc.nextLine();
        ValidationUtils.authenticateID(admin, name, password);
    }

}
