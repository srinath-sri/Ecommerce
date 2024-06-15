package com.ShoppingApplication.ecommerce.Controller;

import com.ShoppingApplication.ecommerce.Dto.ProductMetadata;
import com.ShoppingApplication.ecommerce.Dto.ShopperProductList;
import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Entity.Shelf;
import com.ShoppingApplication.ecommerce.Entity.Shopper;
import com.ShoppingApplication.ecommerce.Exception.ShopperNotFoundException;
import com.ShoppingApplication.ecommerce.Service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopperController {
    @Autowired
    private ShopperService shopperService;

    @PostMapping("/shopper")
    public ResponseEntity<String> saveShopperData(@RequestBody Shopper shopper) {
        String shopperId = shopper.getShopperId();

        // Check if shopperId already exists or handle it as per your requirement
        if (shopperService.exists(shopperId)) {
            throw new ShopperNotFoundException("Shopper with ID " + shopperId + " already exists.");
        }

        // Set shopperId for each shelf item
        for (Shelf shelfItem : shopper.getShelf()) {
            shelfItem.setShopper(shopper);
        }

        // Save the shopper
        shopperService.saveShopperData(shopper);
        return ResponseEntity.ok("Shopper data saved successfully");
    }

    @PostMapping("/product")
    public ResponseEntity<String> saveProductData(@RequestBody Product product) {
        shopperService.saveProductData(product);
        return ResponseEntity.ok("Product data saved successfully");
    }




}