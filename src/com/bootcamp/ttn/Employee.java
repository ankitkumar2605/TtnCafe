package com.bootcamp.ttn;

public class Employee extends User{

    private  int balance;


    public Employee(String id, String name, String email, String password) {
        super(id, name, email, password);
        this.balance = 800;
    }



    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }
}
