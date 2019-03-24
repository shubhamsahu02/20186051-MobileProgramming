package com.example.msit_placement.Model;

public class Users {
    private String name, password, phone;
    public Users(String n, String p, String pass) {
       this.name = n;
       this.phone = p;
       this.password = pass;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
