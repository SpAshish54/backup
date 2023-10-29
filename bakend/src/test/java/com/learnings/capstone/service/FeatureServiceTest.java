package com.learnings.capstone.service;

import com.learnings.capstone.dto.FeatureDTO;
import com.learnings.capstone.dto.ParameterDTO;
import com.learnings.capstone.entity.Feature;
import com.learnings.capstone.entity.Parameter;
import com.learnings.capstone.entity.Product;
import com.learnings.capstone.repository.FeatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class FeatureServiceTest {

    @Mock
    private FeatureRepository featureRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private FeatureService featureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddFeatureToProduct() {

        String productInternalName = "exampleProduct";
        FeatureDTO featureDTO = new FeatureDTO();
        Product product = new Product();
        when(productService.getProductEntityByInternalName(productInternalName)).thenReturn(product);


        featureService.addFeatureToProduct(productInternalName, featureDTO);

        verify(featureRepository, times(1)).save(any(Feature.class));
    }

    @Test
    void testGetFeatureByInternalName() {

        String featureInternalName = "test-feature";
        Feature existingFeature = new Feature();
        existingFeature.setInternalName(featureInternalName);
        existingFeature.setName("TestFeature");
        existingFeature.setDetails("Feature details");

        when(featureRepository.getFeatureEntityByInternalName(featureInternalName)).thenReturn(existingFeature);

        FeatureDTO result = featureService.getFeatureByInternalName(featureInternalName);

        
        assertNotNull(result);
        assertEquals(existingFeature.getName(), result.getName());
        assertEquals(existingFeature.getInternalName(), result.getInternalName());
        assertEquals(existingFeature.getDetails(), result.getDetails());
       

        verify(featureRepository, times(1)).getFeatureEntityByInternalName(featureInternalName);
    }


    @Test
    void testGetAllFeatures() {
    
        List<Feature> features = Collections.singletonList(new Feature());
        when(featureRepository.findAll()).thenReturn(features);

        
        List<FeatureDTO> result = featureService.getAllFeatures();

        
        assertEquals(features.size(), result.size());
    }

    @Test
    void testUpdateFeature() {
    
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setName("TestFeature");
        featureDTO.setInternalName("test-feature");
        featureDTO.setDetails("Feature details");

        Feature existingFeature = new Feature();
        existingFeature.setName("TestFeature");
        existingFeature.setInternalName("test-feature");
        existingFeature.setDetails("Existing details");

        when(featureRepository.getFeatureEntityByInternalName(featureDTO.getInternalName())).thenReturn(existingFeature);
        when(featureRepository.save(any(Feature.class))).thenAnswer(invocation -> {
            Feature savedFeature = invocation.getArgument(0);
            savedFeature.setId(1L); // Simulate the ID assignment by the database
            return savedFeature;
        });

      
        FeatureDTO result = featureService.updateFeature(featureDTO);

    
        assertNotNull(result);
        assertEquals(existingFeature.getName(), result.getName());
        assertEquals(existingFeature.getInternalName(), result.getInternalName());
        assertEquals(existingFeature.getDetails(), result.getDetails());
    

        verify(featureRepository, times(1)).save(any(Feature.class));
    }


    @Test
    void testDeleteFeature() {
        
        String internalName = "exampleFeature";
        Feature existingFeature = new Feature();
        when(featureRepository.getFeatureEntityByInternalName(internalName)).thenReturn(existingFeature);

    
        featureService.deleteFeature(internalName);

        
        verify(featureRepository, times(1)).delete(existingFeature);
    }

    @Test
    void testGetParametersByFeatureInternalName() {
        
        String featureInternalName = "exampleFeature";
        Feature feature = new Feature();
        when(featureRepository.getFeatureEntityByInternalName(featureInternalName)).thenReturn(feature);

        
        List<ParameterDTO> result = featureService.getParametersByFeatureInternalName(featureInternalName);

        
        assertEquals(feature.getParameters().size(), result.size());
    }

    @Test
    void testGetFeaturesByProductInternalName() {
        
        String productInternalName = "exampleProduct";
        List<Feature> features = Collections.singletonList(new Feature());
        when(featureRepository.findByProduct_InternalName(productInternalName)).thenReturn(features);

        
        List<FeatureDTO> result = featureService.getFeaturesByProductInternalName(productInternalName);

        
        assertEquals(features.size(), result.size());
    }
    @Test
    void testFeatureConstructor() {
        // Arrange
        Long id = 1L;
        String name = "Test Feature";
        String internalName = "test-feature";
        String details = "Feature details";
        Product product = new Product();
        List<Parameter> parameters = Collections.singletonList(new Parameter());

        // Act
        Feature feature = new Feature(id, name, internalName, details, product, parameters);

        // Assert
        assertNotNull(feature);
        assertEquals(id, feature.getId());
        assertEquals(name, feature.getName());
        assertEquals(internalName, feature.getInternalName());
        assertEquals(details, feature.getDetails());
        assertEquals(product, feature.getProduct());
        assertEquals(parameters, feature.getParameters());
    }
}
