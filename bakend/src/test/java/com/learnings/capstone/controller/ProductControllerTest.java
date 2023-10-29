package com.learnings.capstone.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learnings.capstone.dto.FeatureDTO;
import com.learnings.capstone.dto.ProductDTO;

import com.learnings.capstone.repository.UserRepository;
import com.learnings.capstone.service.ProductService;



import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductService productService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void testCheckHealth() {
        
        String response = productController.checkhealth();

        
        assertEquals("healthy", response);
    }

    @Test
    void testAddProduct() {
        
        ProductDTO productDTO = new ProductDTO();
        doNothing().when(productService).addProduct(productDTO);

        
        ResponseEntity<Void> response = productController.addProduct(productDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(productService, times(1)).addProduct(productDTO);
    }

    @Test
    void testGetProductByInternalName() {
        
        String internalName = "sampleInternalName";
        ProductDTO expectedProductDTO = new ProductDTO();
        when(productService.getProductByInternalName(internalName)).thenReturn(expectedProductDTO);

        
        ResponseEntity<ProductDTO> response = productController.getProductByInternalName(internalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProductDTO, response.getBody());
        verify(productService, times(1)).getProductByInternalName(internalName);
    }

    @Test
    void testGetAllProducts() {
        
        List<ProductDTO> expectedProductDTOs = Arrays.asList(new ProductDTO(), new ProductDTO());
        when(productService.getAllProducts()).thenReturn(expectedProductDTOs);

        
        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProductDTOs, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetFeaturesByProductInternalName() {
        
        String internalName = "sampleInternalName";
        List<FeatureDTO> expectedFeatureDTOs = Arrays.asList(new FeatureDTO(), new FeatureDTO());
        when(productService.getFeaturesByProductInternalName(internalName)).thenReturn(expectedFeatureDTOs);

        
        ResponseEntity<List<FeatureDTO>> response = productController.getFeaturesByProductInternalName(internalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFeatureDTOs, response.getBody());
        verify(productService, times(1)).getFeaturesByProductInternalName(internalName);
    }

    @Test
    void testUpdateProduct() {
        
        ProductDTO productDTO = new ProductDTO();
        when(productService.updateProduct(productDTO)).thenReturn(productDTO);

        
        ResponseEntity<ProductDTO> response = productController.updateProduct(productDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productDTO, response.getBody());
        verify(productService, times(1)).updateProduct(productDTO);
    }

    @Test
    void testDeleteProduct() {
        
        String internalName = "sampleInternalName";
        doNothing().when(productService).deleteProduct(internalName);

        
        ResponseEntity<Void> response = productController.deleteProduct(internalName);

        
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(internalName);
    }



}


