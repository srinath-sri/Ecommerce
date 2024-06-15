package com.ShoppingApplication.ecommerce.Service;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Entity.Shopper;
import com.ShoppingApplication.ecommerce.Repository.ProductRepository;
import com.ShoppingApplication.ecommerce.Repository.ShopperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopperService {

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void saveShopperData(Shopper shopper) {
        shopperRepository.save(shopper);
    }



    @Transactional
    public void saveProductData(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public boolean exists(String shopperId) {
        return shopperRepository.existsById(shopperId);
    }

}
