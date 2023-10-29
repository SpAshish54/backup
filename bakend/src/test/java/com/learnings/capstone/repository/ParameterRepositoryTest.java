// package com.learnings.capstone.repository;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;


// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.learnings.capstone.entity.Feature;
// import com.learnings.capstone.entity.Parameter;

// import jakarta.transaction.Transactional;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// public class ParameterRepositoryTest {

//     @Autowired
//     private ParameterRepository parameterRepository;

//     @Autowired
//     private FeatureRepository featureRepository;

//     @Test
//     @Transactional
//     public void testGetParameterEntityByInternalName() {
//         // Arrange
//         String internalName = "test-parameter";
//         Parameter parameter = new Parameter();
//         parameter.setInternalName(internalName);
//         Feature feature = new Feature();
//         feature.setName(internalName);
//         parameter.setFeature(feature);
//         parameterRepository.save(parameter);

//         // Act
//         Parameter foundParameter = parameterRepository.getParameterEntityByInternalName(internalName);

//         // Assert
//         assertNotNull(foundParameter);
//         assertEquals(internalName, foundParameter.getInternalName());
//     }

//     @Test
//     @Transactional
//     public void testFindByFeatureInternalName() {
//         // Arrange
//         Feature feature = new Feature();
//         feature.setInternalName("test-feature");
//         featureRepository.save(feature);

//         Parameter parameter = new Parameter();
//         parameter.setInternalName("test-parameter");
//         parameter.setFeature(feature);
//         parameterRepository.save(parameter);

//         // Act
//         List<Parameter> foundParameters = parameterRepository.findByFeature_InternalName("test-feature");

//         // Assert
//         assertNotNull(foundParameters);
//         assertFalse(foundParameters.isEmpty());
//         assertEquals(parameter.getInternalName(), foundParameters.get(0).getInternalName());
//     }
// }
