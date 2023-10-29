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

import com.learnings.capstone.dto.ParameterDTO;
import com.learnings.capstone.service.ParameterService;


import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ParameterControllerTest {

    @InjectMocks
    private ParameterController parameterController;

    @Mock
    private ParameterService parameterService;

    @Test
    void testAddParameterToFeature() {
        
        String featureInternalName = "sampleFeatureInternalName";
        ParameterDTO parameterDTO = new ParameterDTO();
        doNothing().when(parameterService).addParameterToFeature(featureInternalName, parameterDTO);

        
        ResponseEntity<Void> response = parameterController.addParameterToFeature(featureInternalName, parameterDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(parameterService, times(1)).addParameterToFeature(featureInternalName, parameterDTO);
    }

    @Test
    void testGetParameterByInternalName() {
        
        String parameterInternalName = "sampleParameterInternalName";
        ParameterDTO expectedParameterDTO = new ParameterDTO();
        when(parameterService.getParameterByInternalName(parameterInternalName)).thenReturn(expectedParameterDTO);

        
        ResponseEntity<ParameterDTO> response = parameterController.getParameterByInternalName(parameterInternalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedParameterDTO, response.getBody());
        verify(parameterService, times(1)).getParameterByInternalName(parameterInternalName);
    }

    @Test
    void testGetParametersByFeatureInternalName() {
        
        String featureInternalName = "sampleFeatureInternalName";
        List<ParameterDTO> expectedParameterDTOs = Arrays.asList(new ParameterDTO(), new ParameterDTO());
        when(parameterService.getParametersByFeatureInternalName(featureInternalName)).thenReturn(expectedParameterDTOs);

        
        ResponseEntity<List<ParameterDTO>> response = parameterController.getParametersByFeatureInternalName(featureInternalName);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedParameterDTOs, response.getBody());
        verify(parameterService, times(1)).getParametersByFeatureInternalName(featureInternalName);
    }

    @Test
    void testGetAllParameters() {
        
        List<ParameterDTO> expectedParameterDTOs = Arrays.asList(new ParameterDTO(), new ParameterDTO());
        when(parameterService.getAllParameters()).thenReturn(expectedParameterDTOs);

        
        ResponseEntity<List<ParameterDTO>> response = parameterController.getAllParameters();

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedParameterDTOs, response.getBody());
        verify(parameterService, times(1)).getAllParameters();
    }

    @Test
    void testUpdateParameter() {
        
        ParameterDTO parameterDTO = new ParameterDTO();
        when(parameterService.updateParameter(parameterDTO)).thenReturn(parameterDTO);

        
        ResponseEntity<ParameterDTO> response = parameterController.updateParameter(parameterDTO);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(parameterDTO, response.getBody());
        verify(parameterService, times(1)).updateParameter(parameterDTO);
    }

    @Test
    void testDeleteParameter() {
        
        String internalName = "sampleInternalName";
        doNothing().when(parameterService).deleteParameter(internalName);

        
        ResponseEntity<Void> response = parameterController.deleteParameter(internalName);

        
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(parameterService, times(1)).deleteParameter(internalName);
    }
}

