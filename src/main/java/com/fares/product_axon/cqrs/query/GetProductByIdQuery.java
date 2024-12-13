package com.fares.product_axon.cqrs.query;

public class GetProductByIdQuery {
    private final String id;

    public GetProductByIdQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}