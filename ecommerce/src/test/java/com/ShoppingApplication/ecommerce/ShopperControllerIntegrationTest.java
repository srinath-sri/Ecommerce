package com.ShoppingApplication.ecommerce;

import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Entity.Shelf;
import com.ShoppingApplication.ecommerce.Entity.Shopper;
import com.ShoppingApplication.ecommerce.Service.ShopperService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest
@AutoConfigureMockMvc
public class ShopperControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShopperService shopperService;

    @BeforeEach
    void setup() {

    }

    @Test
    public void testSaveShopperData() throws Exception {
        Shopper shopper = new Shopper();
        shopper.setShopperId("shopper1");
        shopper.setShelf(Collections.singletonList(new Shelf()));

        when(shopperService.exists("shopper1")).thenReturn(false);

        mockMvc.perform(post("/api/shopper")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shopper)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Shopper data saved successfully"));

        verify(shopperService, times(1)).saveShopperData(any(Shopper.class));
    }

    @Test
    public void testSaveProductData() throws Exception {
        Product product = new Product();

        mockMvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Product data saved successfully"));

        verify(shopperService, times(1)).saveProductData(any(Product.class));
    }

    @Test
    public void testGetShopperData() throws Exception {
        Shopper shopper = new Shopper();
        shopper.setShopperId("shopper1");

        when(shopperService.getShopperData("shopper1")).thenReturn(Optional.of(shopper));

        mockMvc.perform(get("/api/shopper/shopper1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.shopperId").value("shopper1"));

        verify(shopperService, times(1)).getShopperData("shopper1");
    }

    @Test
    public void testGetShopperData_NotFound() throws Exception {
        when(shopperService.getShopperData("shopper1")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/shopper/shopper1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(shopperService, times(1)).getShopperData("shopper1");
    }
}
