package com.example.Let.sShopping.Repositories;

import com.example.Let.sShopping.models.entities.CategoryEntity;
import com.example.Let.sShopping.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {

    @Modifying
    void deleteById(Long id);
    @Query("select sum(p.price) from ProductEntity p ")
    BigDecimal findTotalSum();

    List<ProductEntity> findAllByCategory(CategoryEntity categoryEntity);
}
