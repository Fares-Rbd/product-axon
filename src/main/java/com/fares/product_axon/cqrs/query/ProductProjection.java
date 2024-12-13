package com.fares.product_axon.cqrs.query;

import com.fares.product_axon.entity.Product;
import com.fares.product_axon.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }

    @QueryHandler
    public List<Product> handle(FindAllProductsQuery query) {
        return productRepository.findAll();
    }

}