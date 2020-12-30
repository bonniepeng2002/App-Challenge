package com.bonniepeng.challenge;

public class Account {

    private String name;
    private String email;
    private String password;
    private String gender;
    private String country;

    public Account(String name, String email, String password, String gender, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }
}
