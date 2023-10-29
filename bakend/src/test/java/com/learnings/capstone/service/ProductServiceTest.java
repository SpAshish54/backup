package com.learnings.capstone.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.learnings.capstone.dto.FeatureDTO;
import com.learnings.capstone.dto.ProductDTO;
import com.learnings.capstone.entity.Feature;
import com.learnings.capstone.entity.Product;
import com.learnings.capstone.entity.Users;
import com.learnings.capstone.repository.FeatureRepository;
import com.learnings.capstone.repository.ProductRepository;
import com.learnings.capstone.repository.UserRepository;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private FeatureRepository featureRepository;

    @MockBean
    private UserRepository userRepository;

    
    @Test
    void testGetProductById() {
        
        Long productId = 1L;
        Product product = new Product();
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        
        ProductDTO result = productService.getProductById(productId);

        
        assertNotNull(result);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testGetProductByInternalName() {
        
        String internalName = "testInternalName";
        Product product = new Product();
        when(productRepository.getProductEntityByInternalName(anyString())).thenReturn(product);

        ProductDTO result = productService.getProductByInternalName(internalName);


        assertNotNull(result);
        verify(productRepository, times(1)).getProductEntityByInternalName(internalName);
    }

    @Test
    void testGetAllProducts() {
       
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        
        List<ProductDTO> result = productService.getAllProducts();

        
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testUpdateProduct() {
        
        ProductDTO productDTO = new ProductDTO();
        productDTO.setInternalName("exampleInternalName"); 
        Product existingProduct = new Product();

        
        when(productRepository.getProductEntityByInternalName(productDTO.getInternalName())).thenReturn(existingProduct);
        when(productRepository.save(any(Product.class))).thenReturn(existingProduct);

        
        ProductDTO result = productService.updateProduct(productDTO);

        
        assertNotNull(result);
        verify(productRepository, times(1)).getProductEntityByInternalName(productDTO.getInternalName());
        verify(productRepository, times(1)).save(any(Product.class));
    }


    @Test
    void testAddProduct() {
        ProductDTO productDTO = new ProductDTO();
        Product product = new Product();

        when(productRepository.save(any(Product.class))).thenReturn(product);
        
        // Mock user data
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("testUser");
        Optional<Users> loggedinUser = Optional.of(new Users());
        loggedinUser.get().setName("testUser");
        when(userRepository.findByName("testUser")).thenReturn(loggedinUser);

        productService.addProduct(productDTO);

        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testDeleteProduct() {
        String internalName = "testInternalName";
        Product existingProduct = new Product();

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("testUser");

        Users loggedinUser = mock(Users.class);
        when(loggedinUser.getProduct()).thenReturn(new ArrayList<>()); // Ensure getProduct() returns a non-null list
        when(userRepository.findByName("testUser")).thenReturn(Optional.of(loggedinUser));

        when(productRepository.getProductEntityByInternalName(internalName)).thenReturn(existingProduct);
        doNothing().when(productRepository).delete(existingProduct);

        productService.deleteProduct(internalName);

        verify(productRepository, times(1)).getProductEntityByInternalName(internalName);
        verify(productRepository, times(1)).delete(existingProduct);
    }


    @Test
    void testGetProductEntityByInternalName() {
        
        String internalName = "exampleInternalName";
        Product expectedProduct = new Product();
        when(productRepository.getProductEntityByInternalName(internalName)).thenReturn(expectedProduct);

        
        Product actualProduct = productService.getProductEntityByInternalName(internalName);

    
        assertNotNull(actualProduct);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testConvertFeatureEntityToDTO() {

        Feature feature = new Feature();
        feature.setName("Test Feature");
        feature.setInternalName("test-feature");

        FeatureDTO result = productService.convertFeatureEntityToDTO(feature);

        assertNotNull(result);
        assertEquals(feature.getName(), result.getName());
        assertEquals(feature.getInternalName(), result.getInternalName());
    }

    @Test
    void testGetProductEntityById() {
        
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setInternalName("test-product");

        
        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(expectedProduct));

        
        Product result = productService.getProductEntityById(productId);

        
        assertNotNull(result);
        assertEquals(expectedProduct.getId(), result.getId());
        assertEquals(expectedProduct.getInternalName(), result.getInternalName());
    }

    
    @Test
    void testGetFeaturesByProductInternalNameWithoutFeatures() {

        String internalName = "test-product";
        Product product = new Product();
        product.setInternalName(internalName);

        product.setFeatures(Collections.emptyList());

        when(featureRepository.findByProduct_InternalName(internalName)).thenReturn(product.getFeatures());

        List<FeatureDTO> result = productService.getFeaturesByProductInternalName(internalName);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testGetFeaturesByProductInternalNameWithNullFeatures() {
        
        String internalName = "test-product";
        Product product = new Product();
        product.setInternalName(internalName);

        product.setFeatures(null);

        when(featureRepository.findByProduct_InternalName(internalName)).thenReturn(null);

        List<FeatureDTO> result = productService.getFeaturesByProductInternalName(internalName);

        
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testProductConstructor() {
        // Arrange
        Long id = 1L;
        String name = "Test Product";
        String internalName = "test-product";
        String details = "Product details";
        Integer maxProductsPerLocation = 10;

        // Act
        Product product = new Product(id, name, internalName, details, maxProductsPerLocation);

        // Assert
        assertNotNull(product);
        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(internalName, product.getInternalName());
        assertEquals(details, product.getDetails());
        assertEquals(maxProductsPerLocation, product.getMaxProductsPerLocation());
    }

}

