package com.example.Let.sShopping.Services.Impl;

import com.example.Let.sShopping.Repositories.CategoryRepository;
import com.example.Let.sShopping.Repositories.ProductRepository;
import com.example.Let.sShopping.Services.ProductService;
import com.example.Let.sShopping.models.entities.ProductEntity;
import com.example.Let.sShopping.models.serviceModels.ProductBuying;
import com.example.Let.sShopping.models.serviceModels.ProductServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return productRepository.findTotalSum();
    }

    @Override
    public List<ProductBuying> findAllByCategory(String category) {
        List<ProductBuying> current =
                productRepository.findAllByCategory(categoryRepository.findByName(category))
                        .stream().map(c -> modelMapper.map(c, ProductBuying.class))
                        .collect(Collectors.toList());
        return current;
    }

    @Override
    public void addProduct(ProductServiceModel product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productEntity.setCategory(categoryRepository.findByName(product.getCategory()));
        productRepository.save(productEntity);

    }

    @Override
    public void buyCurrentProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();

    }
}
