package com.bootcamp.ttn;

import java.util.Scanner;

/**
 * Created by ankit on 24/3/17.
 */
public class EmployeeController extends Controller implements Runnable {
    private Employee emp;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user email : ");
        String name = sc.nextLine();

        System.out.print("Enter user password : ");
        String password = sc.nextLine();

        authenticateEmployee(name, password);
    }

    public void authenticateEmployee(String email, String password) {
        emp = admin.getEmployee(email, password);
        if (emp != null) {
            System.out.println("............Succesfully logged In............");
            showEmployeeUI();
        }

    }

    public void purchaseItem(Admin admin, Employee employee) {
        String productId;
        int productQuantity;
        char wantContinue;
        admin.printInventory();
        do {
            System.out.println("Available Balance : " + employee.getBalance());
            System.out.print("Enter the product id which you want to purchase : ");
            Scanner input = new Scanner(System.in);
            productId = input.nextLine();
            System.out.print("Enter the quantity of product : ");
            productQuantity = Integer.parseInt(input.nextLine());
            if (productQuantity < 0) {
                System.out.println("Enter valid quantity!!!!");
            } else {
                int totalCost = admin.getTotalCost(productId, productQuantity);
                if (totalCost != 0) {
                    if (employee.getBalance() >= totalCost) {
                        admin.updateInventory(productId, productQuantity);
                        admin.printInventory();
                        employee.updateBalance(employee.getBalance() - totalCost);
                    } else {
                        System.out.println("Balance Not Available!!!!!!!!");
                    }
                } else
                    System.out.println("Enter correct product id and quantity!!!!!!!!");
            }
            System.out.print("Do you want to purchase more items?(Y/n): ");
            wantContinue = input.nextLine().charAt(0);
        } while (wantContinue == 'y' || wantContinue == 'Y');
    }

    public void viewDetails() {

    }

    public void viewBalance() {

    }

    public void showEmployeeUI() {

        Scanner sc = new Scanner(System.in);
        char employeeContinue;
        do {
            System.out.println("\n\n\t\t************EMPLOYEE MENU*********************");
            System.out.println("\t\t* 1. EMPLOYEE DETAILS                        *\n" +
                    "\t\t* 2. CURRENT BALANCE                         *\n" +
                    "\t\t* 3. PURCHASE ITEM                           *");
            System.out.println("\t\t**********************************************");
            System.out.print("\n\nEnter your choice ( 1 / 2 / 3 ) : ");
            char employeeChoice = sc.nextLine().charAt(0);
            if (employeeChoice == '1') {
                System.out.println("Employee Name : " + emp.getName());
                System.out.println("Employee ID : " + emp.getId());
                System.out.println("Employee Email : " + emp.getEmail());
                System.out.println("Employee Balance : " + emp.getBalance());
            } else if (employeeChoice == '2') {
                System.out.println("Employee Balance : " + emp.getBalance());

            } else if (employeeChoice == '3') {
                purchaseItem(admin, emp);
            } else {
                System.out.println("Please select valid option!!!!!!");
            }
            System.out.println("Do you want to continue as Employee: ");
            employeeContinue = sc.nextLine().charAt(0);
        } while (employeeContinue == 'Y' || employeeContinue == 'y');
    }


}
