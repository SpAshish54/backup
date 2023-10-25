// package com.learnings.capstone.entity;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.util.ArrayList;
// import java.util.List;

// @SpringBootTest
// public class ProductTest {

//     @Test
//     public void testProductConstructorAndGetters() {
//         // Arrange
//         Long id = 1L;
//         String name = "TestProduct";
//         String internalName = "test-product";
//         String details = "Product details";
//         Integer maxProductsPerLocation = 10;

//         // Act
//         Product product = new Product();
//         product.setId(id);
//         product.setName(name);
//         product.setInternalName(internalName);
//         product.setDetails(details);
//         product.setMaxProductsPerLocation(maxProductsPerLocation);

//         // Assert
//         assertEquals(id, product.getId());
//         assertEquals(name, product.getName());
//         assertEquals(internalName, product.getInternalName());
//         assertEquals(details, product.getDetails());
//         assertEquals(maxProductsPerLocation, product.getMaxProductsPerLocation());
//     }

//     @Test
//     public void testProductSetters() {
//         // Arrange
//         Product product = new Product();
//         Long id = 1L;
//         String name = "TestProduct";
//         String internalName = "test-product";
//         String details = "Product details";
//         Integer maxProductsPerLocation = 10;

//         // Act
//         product.setId(id);
//         product.setName(name);
//         product.setInternalName(internalName);
//         product.setDetails(details);
//         product.setMaxProductsPerLocation(maxProductsPerLocation);

//         // Assert
//         assertEquals(id, product.getId());
//         assertEquals(name, product.getName());
//         assertEquals(internalName, product.getInternalName());
//         assertEquals(details, product.getDetails());
//         assertEquals(maxProductsPerLocation, product.getMaxProductsPerLocation());
//     }

//     @Test
//     public void testProductFeatures() {
//         // Arrange
//         Product product = new Product();
//         List<Feature> features = new ArrayList<>();
//         Feature feature1 = new Feature();
//         Feature feature2 = new Feature();
//         features.add(feature1);
//         features.add(feature2);

//         // Act
//         product.setFeatures(features);

//         // Assert
//         assertEquals(features, product.getFeatures());
//     }

//     @Test
//     public void testProductEqualsAndHashCode() {
//         // Arrange
//         Product product1 = new Product(1L, "TestProduct", "test-product", "Product details", 10);
//         Product product2 = new Product(1L, "TestProduct", "test-product", "Product details", 10);

//         // Act & Assert
//         assertEquals(product1, product2);
//         assertEquals(product1.hashCode(), product2.hashCode());
//     }

//     @Test
//     public void testProductToString() {
//         // Arrange
//         Product product = new Product(1L, "TestProduct", "test-product", "Product details", 10);

//         // Act & Assert
//         assertEquals(
//                 "Product{id=1, name='TestProduct', internalName='test-product', details='Product details', maxProductsPerLocation=10, features=null}",
//                 product.toString());
//     }

//     @Test
//     public void testProductCanEqual() {
//         // Arrange
//         Product product = new Product(1L, "TestProduct", "test-product", "Product details", 10);

//         // Act & Assert
//         assertTrue(product.canEqual(new Product()));
//     }
// }
