package com.bootcamp.ttn;

import java.util.Scanner;

public class TTNCafe {



    public static void main(String[] args) {
        showTTNCafeMenu();
    }

    public static void showTTNCafeMenu(){

        EmployeeController employeeController = new EmployeeController();
        AdminController adminController = new AdminController();
        Scanner sc = new Scanner(System.in);
        boolean ans = false;
        char logInType;
        char loginAgain = 'y';
        char addProduct = 'y';

        do {
            System.out.println("\n\n\t\t**************TTNCAFE MENU******************");
            System.out.println("\t\t* Press A for logged in as ADMIN           *\n" +
                    "\t\t* Press E for logged in as Employee        *");
            System.out.println("\t\t********************************************");
            System.out.print("\n\nEnter your choice ( A / E ) : ");
            logInType = sc.nextLine().charAt(0);
            if (logInType != 'A' && logInType != 'a' && logInType != 'E' && logInType != 'e') {
                System.out.println("Enter valid choice!!!!!!!");
                continue;
            }

            if (logInType == 'A' || logInType == 'a') {
                adminController.startNewAdminThread();
            } else if (logInType == 'E' || logInType == 'e') {
                employeeController.startNewEmployeeThread();
            }
            System.out.println("You are logged out!!!!!\n");
            System.out.print("Do you want to login ( Y / N ): ");
            loginAgain = sc.nextLine().charAt(0);
        } while (loginAgain == 'Y' || loginAgain == 'y');
    }
}