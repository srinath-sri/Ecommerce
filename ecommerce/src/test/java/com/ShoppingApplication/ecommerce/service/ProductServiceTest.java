package com.ShoppingApplication.ecommerce.service;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Repository.ProductRepository;
import com.ShoppingApplication.ecommerce.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductsByShopper_withLimitLessThan100() {
        String shopperId = "shopper1";
        String category = "electronics";
        String brand = "brandA";
        int limit = 50;

        List<Product> products = Collections.singletonList(new Product());
        when(productRepository.findByFilters(category, brand, PageRequest.of(0, limit)))
                .thenReturn(products);

        List<Product> result = productService.getProductsByShopper(shopperId, category, brand, limit);

        assertEquals(products, result);
        verify(productRepository, times(1))
                .findByFilters(category, brand, PageRequest.of(0, limit));
    }

    @Test
    public void testGetProductsByShopper_withLimitMoreThan100() {
        String shopperId = "shopper1";
        String category = "electronics";
        String brand = "brandA";
        int limit = 150;

        List<Product> products = Collections.singletonList(new Product());
        when(productRepository.findByFilters(category, brand, PageRequest.of(0, 100)))
                .thenReturn(products);

        List<Product> result = productService.getProductsByShopper(shopperId, category, brand, limit);

        assertEquals(products, result);
        verify(productRepository, times(1))
                .findByFilters(category, brand, PageRequest.of(0, 100));
    }

    @Test
    public void testGetProductsByShopper_withZeroLimit() {
        String shopperId = "shopper1";
        String category = "electronics";
        String brand = "brandA";
        int limit = 0;

        List<Product> products = Collections.emptyList();
        when(productRepository.findByFilters(category, brand, PageRequest.of(1, limit)))
                .thenReturn(products);

        List<Product> result = productService.getProductsByShopper(shopperId, category, brand, limit);

        assertEquals(products, result);
        verify(productRepository, times(1))
                .findByFilters(category, brand, PageRequest.of(1, limit));
    }
}
