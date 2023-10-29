// package com.learnings.capstone.entity;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.util.ArrayList;
// import java.util.List;

// @SpringBootTest
// public class FeatureTest {

//     @Test
//     public void testFeatureConstructorAndGetters() {
//         // Arrange
//         Long id = 1L;
//         String name = "Feature1";
//         String internalName = "test-feature-1";
//         String details = "Details1";

//         // Create a valid Product instance
//         Product product = new Product();
//         product.setId(2L);  // Set a valid ID for the product
//         product.setName("Product2");
//         product.setInternalName("test-product-2");
//         product.setDetails("Product details");
//         product.setMaxProductsPerLocation(5);

//         // Act
//         Feature feature = new Feature();
//         feature.setId(id);
//         feature.setName(name);
//         feature.setInternalName(internalName);
//         feature.setDetails(details);
//         feature.setProduct(product);

//         // Assert
//         assertEquals(id, feature.getId());
//         assertEquals(name, feature.getName());
//         assertEquals(internalName, feature.getInternalName());
//         assertEquals(details, feature.getDetails());
//         assertEquals(product, feature.getProduct());
//         assertNotNull(feature.getProduct().getId());  // Ensure that the product ID is not null
//     }

//     @Test
//     public void testFeatureSetters() {
//         // Arrange
//         Feature feature = new Feature();
//         Long id = 1L;
//         String name = "TestFeature";
//         String internalName = "test-feature";
//         String details = "Feature details";
//         Product product = new Product();
//         List<Parameter> parameters = new ArrayList<>();

//         // Act
//         feature.setId(id);
//         feature.setName(name);
//         feature.setInternalName(internalName);
//         feature.setDetails(details);
//         feature.setProduct(product);
//         feature.setParameters(parameters);

//         // Assert
//         assertEquals(id, feature.getId());
//         assertEquals(name, feature.getName());
//         assertEquals(internalName, feature.getInternalName());
//         assertEquals(details, feature.getDetails());
//         assertEquals(product, feature.getProduct());
//         assertEquals(parameters, feature.getParameters());
//     }

//     @Test
//     public void testFeatureParameters() {
//         // Arrange
//         Feature feature = new Feature();
//         List<Parameter> parameters = new ArrayList<>();
//         Parameter parameter1 = new Parameter();
//         Parameter parameter2 = new Parameter();
//         parameters.add(parameter1);
//         parameters.add(parameter2);

//         // Act
//         feature.setParameters(parameters);

//         // Assert
//         assertEquals(parameters, feature.getParameters());
//     }

//     @Test
//     public void testEquals() {
//         Feature feature1 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         Feature feature2 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         assertEquals(feature1, feature2);
//     }

//     @Test
//     public void testHashCode() {
//         Feature feature1 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         Feature feature2 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         assertEquals(feature1.hashCode(), feature2.hashCode());
//     }

//     @Test
//     public void testToString() {
//         Feature feature = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         assertEquals("Feature{id=1, name='Feature1', internalName='test-feature-1', details='Details1', product=Product{id=null, name='null', internalName='null', details='null', maxProductsPerLocation=null, features=null}, parameters=[]}", feature.toString());
//     }

//     @Test
//     public void testCanEqual() {
//         Feature feature1 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         Feature feature2 = new Feature(1L, "Feature1", "test-feature-1", "Details1", new Product(), new ArrayList<>());
//         assertTrue(feature1.canEqual(feature2));
//     }
// }
