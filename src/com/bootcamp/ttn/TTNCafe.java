package com.bootcamp.ttn;

import java.util.Scanner;

public class TTNCafe {
    public static void main(String[] args) {
        User admin = new Admin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user ID : ");
        String id = sc.next();

        System.out.print("Enter user password : ");
        String password = sc.next();
        boolean userAuthenticated = ValidationUtils.authenticateID(admin,id,password);
        if(userAuthenticated){
            System.out.println("User Logged In.........");
        }else{
            System.out.println("User ID or Password is Invalid!!!!!!");
        }
    }
}
