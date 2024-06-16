/*
package com.ShoppingApplication.ecommerce;
import com.ShoppingApplication.ecommerce.Entity.Product;
import com.ShoppingApplication.ecommerce.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetProductsByShopper_DefaultLimit() throws Exception {
        List<Product> products = Collections.singletonList(new Product("1", "Product A", "Electronics", "Brand A"));
        Mockito.when(productService.getProductsByShopper(anyString(), anyString(), anyString(), eq(10)))
                .thenReturn(products);

        mockMvc.perform(get("/products")
                        .param("shopperId", "shopper1")
                        .param("category", "electronics")
                        .param("brand", "brandA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Product A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value("Electronics"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand").value("Brand A"));

        Mockito.verify(productService, Mockito.times(1))
                .getProductsByShopper("shopper1", "electronics", "brandA", 10);
    }

    @Test
    public void testGetProductsByShopper_NoProductsFound() throws Exception {
        Mockito.when(productService.getProductsByShopper(anyString(), anyString(), anyString(), anyInt()))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/products")
                        .param("shopperId", "shopper1")
                        .param("category", "electronics")
                        .param("brand", "brandA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        Mockito.verify(productService, Mockito.times(1))
                .getProductsByShopper("shopper1", "electronics", "brandA", 10);
    }
}
*/
