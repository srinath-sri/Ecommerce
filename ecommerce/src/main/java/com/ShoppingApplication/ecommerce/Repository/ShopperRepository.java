package com.ShoppingApplication.ecommerce.Repository;

import com.ShoppingApplication.ecommerce.Entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper, String> {
}
