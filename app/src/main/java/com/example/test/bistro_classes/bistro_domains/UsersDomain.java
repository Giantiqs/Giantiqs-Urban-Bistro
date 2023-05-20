package com.example.test.bistro_classes.bistro_domains;

public class UsersDomain {

    private int id;
    private String username, firstname, middle_name, lastname, password, email, phone_number;

    public UsersDomain(int id,
                       String username,
                       String firstname,
                       String middle_name,
                       String lastname,
                       String password,
                       String email,
                       String phone_number) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.middle_name = middle_name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
