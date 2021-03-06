package com.bootcamp.ttn;

import java.util.Scanner;

public class AdminController extends Controller{

    public void startNewAdminThread(){
        Thread adminThread = new Thread(new AdminThread(this));
        adminThread.start();
        try {
            adminThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void addProductIntoInventory(Admin admin) {
        Scanner input = new Scanner(System.in);
        char addMoreProduct = 'y';
        String productid = "";
        int price, quantity;
        do {
            System.out.println("**********ENTER PRODUCT DETAILS**********");
            System.out.print("Enter product id : ");
            productid = input.nextLine();
            System.out.print("Enter product price : ");
            price = input.nextInt();
            System.out.print("Enter product quantity : ");
            quantity = input.nextInt();
            admin.addNewProduct(new Product(productid, price, quantity));
            input.nextLine();
            System.out.print("Do you want to add more products ( Y / N) ? : ");
            addMoreProduct = input.nextLine().charAt(0);
        } while (addMoreProduct == 'y' || addMoreProduct == 'Y');
    }

    public void removeProductFromInventory(Admin admin) {
        Scanner input = new Scanner(System.in);
        String productid = "";
        char removeMoreProducts;
        do {
            System.out.print("Enter product id : ");
            productid = input.nextLine();
            admin.removeProduct(productid);
            System.out.print("Do you want to remove more products ( Y / N ) ? : ");
            removeMoreProducts = input.nextLine().charAt(0);
        } while (removeMoreProducts == 'y' || removeMoreProducts == 'Y');
    }

    public void addUser(Admin admin) {
        char addMore;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter employee details...........");
            System.out.print("Enter employeeId : ");
            String userId = sc.nextLine();

            System.out.print("Enter userName : ");
            String userName = sc.nextLine();

            System.out.print("Enter email : ");
            String userEmail = sc.nextLine();

            System.out.print("Enter password : ");
            String userPassword = sc.nextLine();

            if (userEmail.equals(admin.getEmail())) {
                System.out.println("User already Exists!!!!!");
            } else if (ValidationUtils.isValidUser(userEmail, userId, userPassword)) {
                if (admin.addUser(new Employee(userId, userName, userEmail, userPassword))) {
                    System.out.println("Employee added successfully!!!!!!!!");
                    System.out.println("No of employees : " + admin.getEmployeeList().size());
                } else {
                    System.out.println("User Not Added!!!!!!");
                }
            } else {
                System.out.println("Enter correct credentials!!!!!!");
            }
            System.out.print("Do you want to add more users ( Y / N ) ? : ");
            addMore = sc.nextLine().charAt(0);
        } while (addMore == 'y' || addMore == 'Y');
        System.out.println("No of employees : " + admin.getEmployeeList().size());
    }

    public void viewBalance(){

    }

    public void viewItemList(){

        admin.printInventory();

    }

    public void viewEmployeeList(){
        System.out.println("|Employee ID    |Employee Name  |Employee Email |");
        for (Employee emp : admin.getEmployeeList()) {
            System.out.printf(" %-13s | %-13s | %-13s \n",emp.getId(),emp.getName(),emp.getEmail());
        }

    }

    public void showAdminUI(){

        Scanner sc = new Scanner(System.in);
        char adminContinue;
        do {
            System.out.println("\n\n\t\t**************ADMIN MENU******************");
            System.out.println("\t\t* 1. ADD USER                            *\n" +
                               "\t\t* 2. ADD PRODUCT                         *\n" +
                               "\t\t* 3. VIEW INEVENTORY                     *\n" +
                               "\t\t* 4. VIEW USERS                          *\n" +
                               "\t\t* 5. REMOVE PRODUCT                      *");
            System.out.println("\t\t******************************************");
            System.out.print("\n\nEnter your choice ( 1 / 2 / 3 / 4 / 5 ) : ");
            char choice = sc.nextLine().charAt(0);
            if (choice == '1') {
                addUser(admin);
            } else if (choice == '2') {
                addProductIntoInventory(admin);
            }else if (choice == '3') {
                viewItemList();
            }
            else if (choice == '4') {
                viewEmployeeList();
            }
            else if (choice == '5') {
                removeProductFromInventory(admin);
            } else {
                System.out.println("Please select valid option!!!!!!");
            }
            System.out.print("Do you want to continue as Admin ( Y / N ) ? : ");
            adminContinue = sc.nextLine().charAt(0);
        } while (adminContinue == 'Y'||adminContinue == 'y');
    }

    public void authenticateAdmin(String email,String password){
        if (ValidationUtils.authenticateCredentials(admin.getEmail(), admin.getPassword(), email, password)) {
            System.out.println("............Succesfully logged In............");
            System.out.println("No of employees : " + admin.getEmployeeList().size());
            showAdminUI();
        } else {
            System.out.println("Invalid username or password!!!!!!");
        }
    }
}
