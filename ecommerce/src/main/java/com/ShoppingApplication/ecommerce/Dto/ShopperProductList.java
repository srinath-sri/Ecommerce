package com.ShoppingApplication.ecommerce.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopperProductList {

    private String shopperId;
    private List<Products> shelf;
}
