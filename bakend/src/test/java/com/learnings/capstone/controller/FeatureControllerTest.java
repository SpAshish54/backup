package com.learnings.capstone.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.learnings.capstone.dto.FeatureDTO;
import com.learnings.capstone.service.FeatureService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FeatureControllerTest {

    @InjectMocks
    private FeatureController featureController;

    @Mock
    private FeatureService featureService;

    @Test
    void testAddFeatureToProduct() {
        
        String productInternalName = "sampleInternalName";
        FeatureDTO featureDTO = new FeatureDTO();
        doNothing().when(featureService).addFeatureToProduct(productInternalName, featureDTO);

        
        ResponseEntity<Void> response = featureController.addFeatureToProduct(productInternalName, featureDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(featureService, times(1)).addFeatureToProduct(productInternalName, featureDTO);
    }

    @Test
    void testGetFeatureByInternalName() {
        
        String internalName = "sampleInternalName";
        FeatureDTO expectedFeatureDTO = new FeatureDTO();
        when(featureService.getFeatureByInternalName(internalName)).thenReturn(expectedFeatureDTO);

        
        ResponseEntity<FeatureDTO> response = featureController.getFeatureByInternalName(internalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFeatureDTO, response.getBody());
        verify(featureService, times(1)).getFeatureByInternalName(internalName);
    }

    @Test
    void testGetFeaturesByProductInternalName() {
        
        String productInternalName = "sampleProductInternalName";
        List<FeatureDTO> expectedFeatureDTOs = Arrays.asList(new FeatureDTO(), new FeatureDTO());
        when(featureService.getFeaturesByProductInternalName(productInternalName)).thenReturn(expectedFeatureDTOs);

        
        ResponseEntity<List<FeatureDTO>> response = featureController.getFeaturesByProductInternalName(productInternalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFeatureDTOs, response.getBody());
        verify(featureService, times(1)).getFeaturesByProductInternalName(productInternalName);
    }

    @Test
    void testGetAllFeatures() {
        
        List<FeatureDTO> expectedFeatureDTOs = Arrays.asList(new FeatureDTO(), new FeatureDTO());
        when(featureService.getAllFeatures()).thenReturn(expectedFeatureDTOs);

        
        ResponseEntity<List<FeatureDTO>> response = featureController.getAllFeatures();

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFeatureDTOs, response.getBody());
        verify(featureService, times(1)).getAllFeatures();
    }

    @Test
    void testUpdateFeature() {
        
        FeatureDTO featureDTO = new FeatureDTO();
        when(featureService.updateFeature(featureDTO)).thenReturn(featureDTO);

        
        ResponseEntity<FeatureDTO> response = featureController.updateFeature(featureDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(featureDTO, response.getBody());
        verify(featureService, times(1)).updateFeature(featureDTO);
    }

    @Test
    void testDeleteFeature() {
        
        String internalName = "sampleInternalName";
        doNothing().when(featureService).deleteFeature(internalName);

        
        ResponseEntity<Void> response = featureController.deleteFeature(internalName);

        
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(featureService, times(1)).deleteFeature(internalName);
    }
}
