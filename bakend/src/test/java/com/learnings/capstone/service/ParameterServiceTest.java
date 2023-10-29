package com.learnings.capstone.service;

import com.learnings.capstone.dto.ParameterDTO;
import com.learnings.capstone.entity.Feature;
import com.learnings.capstone.entity.Parameter;
import com.learnings.capstone.entity.ParameterType;
import com.learnings.capstone.repository.ParameterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ParameterServiceTest {

    @Mock
    private ParameterRepository parameterRepository;

    @Mock
    private FeatureService featureService;

    @InjectMocks
    private ParameterService parameterService;

    @Test
    void testAddParameterToFeature() {
        // Arrange
        String featureInternalName = "test-feature";
        ParameterDTO parameterDTO = new ParameterDTO();
        Feature feature = new Feature();

        when(featureService.getFeatureEntityByInternalName(featureInternalName)).thenReturn(feature);
        when(parameterRepository.save(any(Parameter.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        parameterService.addParameterToFeature(featureInternalName, parameterDTO);

        // Assert
        verify(featureService, times(1)).getFeatureEntityByInternalName(featureInternalName);
        verify(parameterRepository, times(1)).save(any(Parameter.class));
    }

    @Test
    void testGetParameterByInternalName() {
        // Arrange
        String parameterInternalName = "test-parameter";
        Parameter parameter = new Parameter();
        parameter.setInternalName(parameterInternalName);

        when(parameterRepository.getParameterEntityByInternalName(parameterInternalName)).thenReturn(parameter);

        // Act
        ParameterDTO result = parameterService.getParameterByInternalName(parameterInternalName);

        // Assert
        assertNotNull(result);
        assertEquals(parameterInternalName, result.getInternalName());
    }

    @Test
    void testGetAllParameters() {
        // Arrange
        Parameter parameter1 = new Parameter();
        Parameter parameter2 = new Parameter();
        when(parameterRepository.findAll()).thenReturn(Arrays.asList(parameter1, parameter2));

        // Act
        List<ParameterDTO> result = parameterService.getAllParameters();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testUpdateParameter() {
        // Arrange
        ParameterDTO parameterDTO = new ParameterDTO();
        Parameter existingParameter = new Parameter();

        when(parameterRepository.getParameterEntityByInternalName(parameterDTO.getInternalName())).thenReturn(existingParameter);
        when(parameterRepository.save(any(Parameter.class))).thenReturn(existingParameter);

        // Act
        ParameterDTO result = parameterService.updateParameter(parameterDTO);

        // Assert
        assertNotNull(result);
        verify(parameterRepository, times(1)).save(any(Parameter.class));
    }

    @Test
    void testDeleteParameter() {
        // Arrange
        String parameterInternalName = "test-parameter";
        Parameter existingParameter = new Parameter();

        when(parameterRepository.getParameterEntityByInternalName(parameterInternalName)).thenReturn(existingParameter);

        // Act
        parameterService.deleteParameter(parameterInternalName);

        // Assert
        verify(parameterRepository, times(1)).delete(existingParameter);
    }

    @Test
    void testGetParametersByFeatureInternalName() {
        // Arrange
        String featureInternalName = "test-feature";
        Parameter parameter1 = new Parameter();
        Parameter parameter2 = new Parameter();

        when(parameterRepository.findByFeature_InternalName(featureInternalName)).thenReturn(Arrays.asList(parameter1, parameter2));

        // Act
        List<ParameterDTO> result = parameterService.getParametersByFeatureInternalName(featureInternalName);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testParameterConstructor() {
        // Arrange
        Long id = 1L;
        String name = "Test Parameter";
        String internalName = "test-parameter";
        String details = "Parameter details";
        ParameterType parameterType = ParameterType.QUANTITY; // Replace with the actual parameter type
        Feature feature = new Feature();

        // Act
        Parameter parameter = new Parameter(id, name, internalName, details, parameterType, "Test Value", feature);

        // Assert
        assertNotNull(parameter);
        assertEquals(id, parameter.getId());
        assertEquals(name, parameter.getName());
        assertEquals(internalName, parameter.getInternalName());
        assertEquals(details, parameter.getDetails());
        assertEquals(parameterType, parameter.getParameterType());
        assertEquals("Test Value", parameter.getValue());
        assertEquals(feature, parameter.getFeature());
    }

}
