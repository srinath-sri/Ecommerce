package com.ShoppingApplication.ecommerce.Repository;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Entity.Shopper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
