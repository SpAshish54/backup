// package com.learnings.capstone.service;

// import com.learnings.capstone.dto.FeatureDTO;
// import com.learnings.capstone.dto.ParameterDTO;
// import com.learnings.capstone.entity.Feature;
// import com.learnings.capstone.entity.Product;
// import com.learnings.capstone.repository.FeatureRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.util.Collections;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// @SpringBootTest
// public class FeatureServiceTest {

//     @Mock
//     private FeatureRepository featureRepository;

//     @Mock
//     private ProductService productService;

//     @InjectMocks
//     private FeatureService featureService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testAddFeatureToProduct() {
//         // Arrange
//         String productInternalName = "exampleProduct";
//         FeatureDTO featureDTO = new FeatureDTO();
//         Product product = new Product();
//         when(productService.getProductEntityByInternalName(productInternalName)).thenReturn(product);

//         // Act
//         featureService.addFeatureToProduct(productInternalName, featureDTO);

//         // Assert
//         verify(featureRepository, times(1)).save(any(Feature.class));
//     }

//     @Test
//     public void testGetFeatureByInternalName() {
//         // Arrange
//         String featureInternalName = "test-feature";
//         Feature existingFeature = new Feature();
//         existingFeature.setInternalName(featureInternalName);
//         existingFeature.setName("TestFeature");
//         existingFeature.setDetails("Feature details");

//         when(featureRepository.getFeatureEntityByInternalName(featureInternalName)).thenReturn(existingFeature);

//         // Act
//         FeatureDTO result = featureService.getFeatureByInternalName(featureInternalName);

//         // Assert
//         assertNotNull(result);
//         assertEquals(existingFeature.getName(), result.getName());
//         assertEquals(existingFeature.getInternalName(), result.getInternalName());
//         assertEquals(existingFeature.getDetails(), result.getDetails());
//         // Add more assertions as needed

//         verify(featureRepository, times(1)).getFeatureEntityByInternalName(featureInternalName);
//     }


//     @Test
//     public void testGetAllFeatures() {
//         // Arrange
//         List<Feature> features = Collections.singletonList(new Feature());
//         when(featureRepository.findAll()).thenReturn(features);

//         // Act
//         List<FeatureDTO> result = featureService.getAllFeatures();

//         // Assert
//         assertEquals(features.size(), result.size());
//     }

//     @Test
//     public void testUpdateFeature() {
//     // Arrange
//         FeatureDTO featureDTO = new FeatureDTO();
//         featureDTO.setName("TestFeature");
//         featureDTO.setInternalName("test-feature");
//         featureDTO.setDetails("Feature details");

//         Feature existingFeature = new Feature();
//         existingFeature.setName("TestFeature");
//         existingFeature.setInternalName("test-feature");
//         existingFeature.setDetails("Existing details");

//         when(featureRepository.getFeatureEntityByInternalName(featureDTO.getInternalName())).thenReturn(existingFeature);
//         when(featureRepository.save(any(Feature.class))).thenAnswer(invocation -> {
//             Feature savedFeature = invocation.getArgument(0);
//             savedFeature.setId(1L); // Simulate the ID assignment by the database
//             return savedFeature;
//         });

//         // Act
//         FeatureDTO result = featureService.updateFeature(featureDTO);

//         // Assert
//         assertNotNull(result);
//         assertEquals(existingFeature.getName(), result.getName());
//         assertEquals(existingFeature.getInternalName(), result.getInternalName());
//         assertEquals(existingFeature.getDetails(), result.getDetails());
//         // Add more assertions as needed

//         verify(featureRepository, times(1)).save(any(Feature.class));
//     }


//     @Test
//     public void testDeleteFeature() {
//         // Arrange
//         String internalName = "exampleFeature";
//         Feature existingFeature = new Feature();
//         when(featureRepository.getFeatureEntityByInternalName(internalName)).thenReturn(existingFeature);

//         // Act
//         featureService.deleteFeature(internalName);

//         // Assert
//         verify(featureRepository, times(1)).delete(existingFeature);
//     }

//     @Test
//     public void testGetParametersByFeatureInternalName() {
//         // Arrange
//         String featureInternalName = "exampleFeature";
//         Feature feature = new Feature();
//         when(featureRepository.getFeatureEntityByInternalName(featureInternalName)).thenReturn(feature);

//         // Act
//         List<ParameterDTO> result = featureService.getParametersByFeatureInternalName(featureInternalName);

//         // Assert
//         assertEquals(feature.getParameters().size(), result.size());
//     }

//     @Test
//     public void testGetFeaturesByProductInternalName() {
//         // Arrange
//         String productInternalName = "exampleProduct";
//         List<Feature> features = Collections.singletonList(new Feature());
//         when(featureRepository.findByProduct_InternalName(productInternalName)).thenReturn(features);

//         // Act
//         List<FeatureDTO> result = featureService.getFeaturesByProductInternalName(productInternalName);

//         // Assert
//         assertEquals(features.size(), result.size());
//     }
// }
