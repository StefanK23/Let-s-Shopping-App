package com.example.Let.sShopping.models.bindings;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddingBindingModel {

    @Length(min = 3, message = "Name must be between 3 and 20 characters")
    @NotEmpty
    private String name;

    @Length(min = 5,message = "Description must be more than 5 characters!")
    @NotEmpty
    private String description;

    @FutureOrPresent(message = "The date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;

    @Positive(message = "Price must be positive number!")
    @NotNull
    private BigDecimal price;

    @NotEmpty(message = "Category is required!")
    private String category;

    public String getName() {
        return name;
    }

    public ProductAddingBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddingBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddingBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddingBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductAddingBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
