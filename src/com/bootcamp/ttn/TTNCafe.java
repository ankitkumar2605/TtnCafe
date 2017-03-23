package com.bootcamp.ttn;

import java.util.Scanner;

public class TTNCafe {

    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        boolean ans = false;
        char logInType;
        char loginAgain = 'y';
        char addProduct = 'y';

        do {
            System.out.println("Press A for logged in as admin\nPress E for logged in as employee");
            System.out.print("\n\nEnter your choice : ");
            logInType = sc.nextLine().charAt(0);
            if (logInType != 'A' && logInType != 'a' && logInType != 'E' && logInType != 'e') {
                System.out.println("Enter valid choice!!!!!!!");
                continue;
            }
            System.out.print("Enter user name : ");
            String name = sc.nextLine();

            System.out.print("Enter user password : ");
            String password = sc.nextLine();


            if (logInType == 'A' || logInType == 'a') {

                if (ValidationUtils.authenticateCredentials(admin.getEmail(), admin.getPassword(), name, password)) {
                    System.out.println("No of employees" + admin.getEmployeeList().size());
                    char addMore;
                    do {
                        System.out.println("Enter employee details:");
                        System.out.println("Enter employeeId:");
                        String userId = sc.nextLine();

                        System.out.println("Enter userName:");
                        String userName = sc.nextLine();

                        System.out.println("Enter email:");
                        String userEmail = sc.nextLine();

                        System.out.println("Enter pasword");
                        String userPassword = sc.nextLine();


                        if (ValidationUtils.isValidUser(userEmail, userId, userPassword)) {
                            if (admin.addUser(new Employee(userId, userName, userEmail, userPassword))) {
                                System.out.println("Employee added successfully");
                                System.out.println("No of employees" + admin.getEmployeeList().size());
                            } else {
                                System.out.println("User Not Added!!!!!!");
                            }
                        } else {
                            System.out.println("Enter correct credentials");
                        }

                        System.out.println("do you want to continue?(y/n)");
                        addMore = sc.nextLine().charAt(0);
                    } while (addMore == 'y' || addMore == 'Y');
                    System.out.println("No of employees" + admin.getEmployeeList().size());
                    Controller.productInfo(admin);
                } else {
                    System.out.println("Invalid username or password!!!!!!");
                }
            } else if (logInType == 'E' || logInType == 'e') {
                Employee emp = admin.getEmployee(name, password);
                if (emp != null) {
                    System.out.println("Employee Name : " + emp.getName());
                    System.out.println("Employee ID : " + emp.getId());
                    System.out.println("Employee Email : " + emp.getEmail());
                    System.out.println("Employee Balance : " + emp.getBalance());
                    Controller.purchaseItem(admin);

                }


            }
            System.out.println("You are logged out!!!!!");
            System.out.println("Do you want to login : ");
            loginAgain = sc.nextLine().charAt(0);
        } while (loginAgain == 'Y' || loginAgain == 'y');




    }
}