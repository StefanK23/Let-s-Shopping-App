package com.example.Let.sShopping.Services;

import com.example.Let.sShopping.models.serviceModels.ProductBuying;
import com.example.Let.sShopping.models.serviceModels.ProductServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    BigDecimal getTotalPrice();

    List<ProductBuying> findAllByCategory(String category);

    void addProduct(ProductServiceModel product);

    void buyCurrentProduct(Long id);

    void buyAllProducts();
}
