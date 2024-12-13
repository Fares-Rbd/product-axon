package com.fares.product_axon.cqrs.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


public class CreateProductCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;

    public CreateProductCommand(String id, String name, String description, double price, int
            stock) {
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
}