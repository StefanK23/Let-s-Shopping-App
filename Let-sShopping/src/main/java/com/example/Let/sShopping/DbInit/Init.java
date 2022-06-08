package com.example.Let.sShopping.DbInit;

import com.example.Let.sShopping.Repositories.CategoryRepository;
import com.example.Let.sShopping.models.entities.CategoryEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init  implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public Init(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count() == 0 ){
            initCategories();
        }
    }

    private void initCategories() {

        CategoryEntity food= new CategoryEntity();
        food.setName("Food");
        CategoryEntity drink= new CategoryEntity();
        drink.setName("Drink");
        CategoryEntity household= new CategoryEntity();
        household.setName("Household");
        CategoryEntity other= new CategoryEntity();
        other.setName("Other");
        categoryRepository.saveAll(List.of(food,drink,household,other));
    }
}
