package com.example.Let.sShopping.Services.Impl;

import com.example.Let.sShopping.Repositories.CategoryRepository;
import com.example.Let.sShopping.Services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<String> getAllCategories() {
        List<String> result = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryEntity -> result.add(categoryEntity.getName()));
        return result;
    }
}
