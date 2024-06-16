package com.ShoppingApplication.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Shelf {

    @Id
    private String productId;
    private double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;
}
