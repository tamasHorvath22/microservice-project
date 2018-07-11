package com.codecool.microservices.model;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public User(int id, String firstName, String lastName, String email, String address, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
