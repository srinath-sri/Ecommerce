package com.ShoppingApplication.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Shopper {
    @Id
    private String shopperId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shopper")
    private List<Shelf> shelf;

}
