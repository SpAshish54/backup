// package com.learnings.capstone.entity;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// public class ParameterTest {

//     @Test
//     public void testParameterConstructorAndGetters() {
//         // Arrange
//         Long id = 1L;
//         String name = "TestParameter";
//         String internalName = "test-parameter";
//         String details = "Parameter details";
//         ParameterType parameterType = ParameterType.QUANTITY;
//         Feature feature = new Feature();
//         // Act
//         Parameter parameter = new Parameter();
//         parameter.setId(id);
//         parameter.setName(name);
//         parameter.setInternalName(internalName);
//         parameter.setDetails(details);
//         parameter.setParameterType(parameterType);
//         parameter.setFeature(feature);

//         // Assert
//         assertEquals(id, parameter.getId());
//         assertEquals(name, parameter.getName());
//         assertEquals(internalName, parameter.getInternalName());
//         assertEquals(details, parameter.getDetails());
//         assertEquals(parameterType, parameter.getParameterType());
//         assertEquals(feature, parameter.getFeature());
//     }

//     @Test
//     public void testParameterSetters() {
//         // Arrange
//         Parameter parameter = new Parameter();
//         Long id = 1L;
//         String name = "TestParameter";
//         String internalName = "test-parameter";
//         String details = "Parameter details";
//         ParameterType parameterType = ParameterType.QUANTITY;
//         Feature feature = new Feature();

//         // Act
//         parameter.setId(id);
//         parameter.setName(name);
//         parameter.setInternalName(internalName);
//         parameter.setDetails(details);
//         parameter.setParameterType(parameterType);
//         parameter.setFeature(feature);

//         // Assert
//         assertEquals(id, parameter.getId());
//         assertEquals(name, parameter.getName());
//         assertEquals(internalName, parameter.getInternalName());
//         assertEquals(details, parameter.getDetails());
//         assertEquals(parameterType, parameter.getParameterType());
//         assertEquals(feature, parameter.getFeature());
//     }

//     @Test
//     public void testParameterEquals() {
//         Parameter parameter1 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         Parameter parameter2 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         assertEquals(parameter1, parameter2);
//     }

//     @Test
//     public void testParameterHashCode() {
//         Parameter parameter1 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         Parameter parameter2 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         assertEquals(parameter1.hashCode(), parameter2.hashCode());
//     }

//     @Test
//     public void testParameterToString() {
//         Feature feature = new Feature();
//         feature.setId(1L);
//         feature.setName("TestFeature");
//         feature.setInternalName("test-feature");
//         feature.setDetails("Feature details");

//         Product product = new Product();
//         product.setId(1L);
//         product.setName("TestProduct");
//         product.setInternalName("test-product");
//         product.setDetails("Product details");

//         feature.setProduct(product);

//         Parameter parameter = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, feature);

//         String expected = "Parameter{" +
//                 "id=1, " +
//                 "name='TestParameter', " +
//                 "internalName='test-parameter', " +
//                 "details='Parameter details', " +
//                 "parameterType=QUANTITY, " +
//                 "feature=Feature{id=1, name='TestFeature', internalName='test-feature', details='Feature details', product=Product{id=1, name='TestProduct', internalName='test-product', details='Product details', maxProductsPerLocation=null, features=null}, parameters=[]}, " +
//                 "product=Product{id=1, name='TestProduct', internalName='test-product', details='Product details', maxProductsPerLocation=null, features=null}" +
//                 '}';
        
//         assertEquals(expected, parameter.toString());
//     }


//     @Test
//     public void testParameterCanEqual() {
//         Parameter parameter1 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         Parameter parameter2 = new Parameter(1L, "TestParameter", "test-parameter", "Parameter details", ParameterType.QUANTITY, new Feature());
//         assertTrue(parameter1.canEqual(parameter2));
//     }
//     }
