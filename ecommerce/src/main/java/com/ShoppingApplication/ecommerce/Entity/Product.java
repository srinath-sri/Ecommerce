package com.ShoppingApplication.ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private String productId;
    private String category;
    private String brand;

}
