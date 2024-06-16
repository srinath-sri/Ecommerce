package com.ShoppingApplication.ecommerce.Service;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByShopper(String shopperId, String category, String brand, int limit) {

        int maxLimit = Math.min(limit, 100); // Ensure limit does not exceed 100

        return productRepository.findByFilters(category, brand, PageRequest.of(0, maxLimit));
    }
}
