package com.example.myapplication.Doituong;

public class Account {

    String user ;
    String password;
    String hovaten ;

    public Account(String user, String password, String hovaten) {
        this.user = user;
        this.password = password;
        this.hovaten = hovaten;
    }
    public Account(String user, String password) {
        this.user = user;
        this.password = password;

    }


    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getHovaten() {
        return hovaten;
    }
}
