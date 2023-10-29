// package com.learnings.capstone.repository;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.transaction.annotation.Transactional;

// import com.learnings.capstone.entity.Product;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// public class ProductRepositoryTest {

//     @Autowired
//     private ProductRepository productRepository;

//     @Test
//     @Transactional
//     public void testGetProductEntityByInternalName() {
//         // Arrange
//         String internalName = "test-product";
//         Product product = new Product();
//         product.setInternalName(internalName);

//         // Act
//         productRepository.save(product);
//         Product foundProduct = productRepository.getProductEntityByInternalName(internalName);

//         // Assert
//         assertNotNull(foundProduct);
//         assertEquals(internalName, foundProduct.getInternalName());
//     }
// }
