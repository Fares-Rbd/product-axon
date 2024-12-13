package com.fares.product_axon.controller;

import com.fares.product_axon.cqrs.commands.CreateProductCommand;
import com.fares.product_axon.cqrs.query.FindAllProductsQuery;
import com.fares.product_axon.cqrs.query.GetProductByIdQuery;
import com.fares.product_axon.entity.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        String id = UUID.randomUUID().toString();
        CreateProductCommand command = new CreateProductCommand(
                id, product.getName(), product.getDescription(), product.getPrice(),
                product.getStock());
        commandGateway.sendAndWait(command);
        return id;
    }

    @GetMapping("/{id}")
    public Product getProductByUUID(@PathVariable String id){

        return queryGateway.query(new GetProductByIdQuery(id),Product.class).join();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return queryGateway.query(new FindAllProductsQuery(), ResponseTypes.multipleInstancesOf(Product.class)).join();
    }

}