package com.bootcamp.ttn;

import java.util.Scanner;

public class TTNCafe {



    public static void main(String[] args) {
        showTTNCafeMenu();
    }

    public static void showTTNCafeMenu(){

        EmployeeController employeeController = new EmployeeController();
        AdminController adminController = new AdminController();
        Thread adminThread = new Thread(adminController);
        Thread employeeThread = new Thread(employeeController);
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
                adminThread = new Thread(adminController);
                adminThread.start();
            } else if (logInType == 'E' || logInType == 'e') {

                employeeThread = new Thread(employeeController);
                employeeThread.start();
            }
            try{
                adminThread.join();
                employeeThread.join();
            }catch (InterruptedException ie){
                System.out.println("Internal Server Error!!!!");
            }
            System.out.println("You are logged out!!!!!\n");
            System.out.print("Do you want to login : ");
            loginAgain = sc.nextLine().charAt(0);
        } while (loginAgain == 'Y' || loginAgain == 'y');
    }




}