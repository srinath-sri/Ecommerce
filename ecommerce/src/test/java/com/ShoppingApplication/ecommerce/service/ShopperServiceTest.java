package com.ShoppingApplication.ecommerce.service;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Entity.Shopper;
import com.ShoppingApplication.ecommerce.Repository.ProductRepository;
import com.ShoppingApplication.ecommerce.Repository.ShopperDataRepository;
import com.ShoppingApplication.ecommerce.Repository.ShopperRepository;
import com.ShoppingApplication.ecommerce.Service.ShopperService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShopperServiceTest {

    @Mock
    private ShopperRepository shopperRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ShopperDataRepository shopperDataRepository;

    @InjectMocks
    private ShopperService shopperService;

    @Captor
    private ArgumentCaptor<Shopper> shopperCaptor;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void testSaveShopperData() {
        Shopper shopper = new Shopper();
        shopper.setShopperId("shopper1");

        shopperService.saveShopperData(shopper);

        verify(shopperRepository, times(1)).save(shopperCaptor.capture());
        Shopper capturedShopper = shopperCaptor.getValue();
        assertEquals("shopper1", capturedShopper.getShopperId());
    }

    @Test
    public void testSaveProductData() {
        Product product = new Product();

        shopperService.saveProductData(product);

        verify(productRepository, times(1)).save(productCaptor.capture());
        Product capturedProduct = productCaptor.getValue();
        assertNotNull(capturedProduct);
    }

    @Test
    public void testExists() {
        when(shopperRepository.existsById("shopper1")).thenReturn(true);

        boolean exists = shopperService.exists("shopper1");

        assertTrue(exists);
        verify(shopperRepository, times(1)).existsById("shopper1");
    }

    @Test
    public void testGetShopperData() {
        Shopper shopper = new Shopper();
        shopper.setShopperId("shopper1");

        when(shopperDataRepository.findByShopperId("shopper1")).thenReturn(shopper);

        Optional<Shopper> foundShopper = shopperService.getShopperData("shopper1");

        assertTrue(foundShopper.isPresent());
        assertEquals("shopper1", foundShopper.get().getShopperId());
        verify(shopperDataRepository, times(1)).findByShopperId("shopper1");
    }

    @Test
    public void testGetShopperData_NotFound() {
        when(shopperDataRepository.findByShopperId("shopper1")).thenReturn(null);

        Optional<Shopper> foundShopper = shopperService.getShopperData("shopper1");

        assertFalse(foundShopper.isPresent());
        verify(shopperDataRepository, times(1)).findByShopperId("shopper1");
    }
}
