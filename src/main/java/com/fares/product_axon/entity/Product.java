package com.fares.product_axon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private final String id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false, length = 500)
    private final String description;

    @Column(nullable = false)
    private final double price;

    @Column(nullable = false)
    private final int stock;

    // No-args constructor for JPA
    protected Product() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.price = 0.0;
        this.stock = 0;
    }

    // Constructor with all fields
    public Product(String id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}