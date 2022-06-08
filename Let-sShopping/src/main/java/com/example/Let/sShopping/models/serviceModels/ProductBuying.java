package com.example.Let.sShopping.models.serviceModels;

import java.math.BigDecimal;

public class ProductBuying {
    private Long id;
    private String name;
    private BigDecimal price;

    public Long getId() {

        return id;
    }

    public ProductBuying setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductBuying setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductBuying setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
