// package com.learnings.capstone.dto;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// public class FeatureDTOTest {

//     @Test
//     public void testEquals() {
//         // Arrange
//         FeatureDTO feature1 = new FeatureDTO();
//         feature1.setName("Feature1");
//         feature1.setInternalName("test-feature-1");
//         feature1.setDetails("Details1");

//         FeatureDTO feature2 = new FeatureDTO();
//         feature2.setName("Feature1");
//         feature2.setInternalName("test-feature-1");
//         feature2.setDetails("Details1");

//         // Act and Assert
//         assertEquals(feature1, feature2);
//     }

//     @Test
//     public void testHashCode() {
//         // Arrange
//         FeatureDTO feature1 = new FeatureDTO();
//         feature1.setName("Feature1");
//         feature1.setInternalName("test-feature-1");
//         feature1.setDetails("Details1");

//         FeatureDTO feature2 = new FeatureDTO();
//         feature2.setName("Feature1");
//         feature2.setInternalName("test-feature-1");
//         feature2.setDetails("Details1");

//         // Act and Assert
//         assertEquals(feature1.hashCode(), feature2.hashCode());
//     }

//     @Test
//     public void testToString() {
//         // Arrange
//         FeatureDTO feature = new FeatureDTO();
//         feature.setName("Feature1");
//         feature.setInternalName("test-feature-1");
//         feature.setDetails("Details1");

//         // Act and Assert
//         String expected = "FeatureDTO{name='Feature1', internalName='test-feature-1', details='Details1'}";
//         assertEquals(expected, feature.toString());
//     }

//     @Test
//     public void testCanEqual() {
//         // Arrange
//         FeatureDTO feature1 = new FeatureDTO();
//         feature1.setName("Feature1");
//         feature1.setInternalName("test-feature-1");
//         feature1.setDetails("Details1");

//         FeatureDTO feature2 = new FeatureDTO();
//         feature2.setName("Feature1");
//         feature2.setInternalName("test-feature-1");
//         feature2.setDetails("Details1");

//         // Act and Assert
//         assertTrue(feature1.canEqual(feature2));
//     }
// }
