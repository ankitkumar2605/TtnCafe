package com.bootcamp.ttn;

public class Employee extends User implements TTNCafeInterface{

    private  int balance;


    public Employee(String id, String name, String email, String password) {
        super(id, name, email, password);
        this.balance = 800;
    }


    public Employee() {
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance() {
        this.balance = balance;
    }

    public void updateBalance(int balance) {
        this.balance = balance;
    }
}
