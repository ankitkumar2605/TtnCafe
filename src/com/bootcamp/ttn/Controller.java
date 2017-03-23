package com.bootcamp.ttn;

import java.util.Scanner;

/**
 * Created by ankit on 23/3/17.
 */
public class Controller {

    public static void productInfo(Admin admin) {

        Scanner input = new Scanner(System.in);
        char addProduct = 'y';
        char wantContinue = 'y';
        String productid="";
        int price,quantity;
        do {
            System.out.println("Do you want to add product or remove product(a/r)?");
            addProduct = input.nextLine().charAt(0);
            if (addProduct == 'a' || addProduct == 'A'){
                System.out.println("Enter product id:");
                productid = input.nextLine();
                System.out.println("Enter product price:");
                price = input.nextInt();
                System.out.println("Enter product quantity");
                quantity = input.nextInt();
                admin.addProduct(new Product(productid,price,quantity));
                input.nextLine();
            }

            else if(addProduct == 'r' || addProduct =='R'){
                System.out.println("Enter product id:");
                productid = input.nextLine();
                admin.removeProduct(productid);
            }
            System.out.println("Do you want to continue?(y/n)");
            wantContinue = input.nextLine().charAt(0);
        }while(wantContinue == 'y' || wantContinue == 'Y');


    }

    public static void purchaseItem(Admin admin){
        String productId;
        char wantContinue;
        admin.printInventory();
        do {
            System.out.println("Enter the product id which you want to purchase:");
            Scanner input = new Scanner(System.in);
            productId = input.nextLine();
            admin.updateInventory(productId);
            admin.printInventory();
            System.out.println("Do you want to purchase more items?(Y/n)");
            wantContinue = input.nextLine().charAt(0);
        }while (wantContinue == 'y' || wantContinue == 'Y');


    }

}
