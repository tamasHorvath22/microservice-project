package com.codecool.microservices.model;

import java.util.Date;

public class Present {

    private long id;
    private String name;
    private double price;

    private String category;
    private boolean available;
    private int ownerId;
    private Date timestamp;

    public Present(int id, String name, double price, String category, boolean available, int ownerId, Date timestamp) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
        this.ownerId = ownerId;
        this.timestamp = timestamp;
    }

    public long getId() {
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
