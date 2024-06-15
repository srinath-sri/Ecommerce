package com.ShoppingApplication.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;
}
