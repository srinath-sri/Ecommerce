package com.ShoppingApplication.ecommerce.Repository;

import com.ShoppingApplication.ecommerce.Entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) AND (:brand IS NULL OR p.brand = :brand)")
    List<Product> findByFilters(@Param("category") String category, @Param("brand") String brand, PageRequest pageable);
}

