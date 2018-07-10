package com.codecool.microservices.model;


public class Wallet {

    private long id;
    private double balance;

    public Wallet(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
