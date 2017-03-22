package com.bootcamp.ttn;


import java.util.Scanner;

public class Admin extends User{

    public Admin() {
        id = "100001";
        password = "admin";
    }

    public Admin(String id, String name, String email, String password) {

        super(id, name, email, password);
    }


}
