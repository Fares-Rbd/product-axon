package com.fares.product_axon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fares.product_axon")
public class ProductAxonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductAxonApplication.class, args);
    }

}
