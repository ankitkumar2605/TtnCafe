package com.bootcamp.ttn;

public class User extends TTNCafeBase{
    protected String name;
    protected String email;
    protected String password;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "user";
    }

    public User(String  id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
