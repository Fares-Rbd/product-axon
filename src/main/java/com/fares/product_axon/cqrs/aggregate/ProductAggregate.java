package com.fares.product_axon.cqrs.aggregate;

import com.fares.product_axon.cqrs.commands.CreateProductCommand;
import com.fares.product_axon.cqrs.events.ProductCreatedEvent;
import com.fares.product_axon.entity.Product;
import com.fares.product_axon.repository.ProductRepository; // Add this import
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    private final ProductRepository productRepository;  // Add this field

    @Autowired
    public ProductAggregate(ProductRepository productRepository) { // Constructor injection
        this.productRepository = productRepository;
    }


    @CommandHandler
    public ProductAggregate(CreateProductCommand command, ProductRepository productRepository) {
        this.productRepository = productRepository;
        // Apply an event
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription(),
                command.getPrice(),
                command.getStock()
        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();

        // Save to the database
        Product product = new Product(this.id, this.name, this.description, this.price, this.stock);
        productRepository.save(product);
    }
}
