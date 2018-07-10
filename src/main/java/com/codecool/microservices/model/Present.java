package com.codecool.microservices.model;

public class Present {

    private int id;
    private String name;
    private double price;

    private String category;
    private boolean available;
    private int ownerId;

    public Present(int id, String name, double price, String category, boolean available, int ownerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
