// package com.learnings.capstone.service;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;

// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.learnings.capstone.dto.FeatureDTO;
// import com.learnings.capstone.dto.ProductDTO;
// import com.learnings.capstone.entity.Feature;
// import com.learnings.capstone.entity.Product;
// import com.learnings.capstone.repository.FeatureRepository;
// import com.learnings.capstone.repository.ProductRepository;

// import static org.mockito.ArgumentMatchers.*;
// import static org.mockito.Mockito.*;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Optional;

// @SpringBootTest
// @ExtendWith(MockitoExtension.class)
// public class ProductServiceTest {

//     @InjectMocks
//     private ProductService productService;

//     @MockBean
//     private ProductRepository productRepository;

//     @MockBean
//     private FeatureRepository featureRepository;

//     @Test
//     public void testAddProduct() {
//         // Arrange
//         ProductDTO productDTO = new ProductDTO();
//         Product product = new Product();
//         when(productRepository.save(any(Product.class))).thenReturn(product);

//         // Act
//         productService.addProduct(productDTO);

//         // Assert
//         verify(productRepository, times(1)).save(any(Product.class));
//     }

//     @Test
//     public void testGetProductById() {
//         // Arrange
//         Long productId = 1L;
//         Product product = new Product();
//         when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

//         // Act
//         ProductDTO result = productService.getProductById(productId);

//         // Assert
//         assertNotNull(result);
//         verify(productRepository, times(1)).findById(productId);
//     }

//     @Test
//     public void testGetProductByInternalName() {
//         // Arrange
//         String internalName = "testInternalName";
//         Product product = new Product();
//         when(productRepository.getProductEntityByInternalName(anyString())).thenReturn(product);

//         // Act
//         ProductDTO result = productService.getProductByInternalName(internalName);

//         // Assert
//         assertNotNull(result);
//         verify(productRepository, times(1)).getProductEntityByInternalName(internalName);
//     }

//     @Test
//     public void testGetAllProducts() {
//         // Arrange
//         List<Product> products = Arrays.asList(new Product(), new Product());
//         when(productRepository.findAll()).thenReturn(products);

//         // Act
//         List<ProductDTO> result = productService.getAllProducts();

//         // Assert
//         assertEquals(products.size(), result.size());
//         verify(productRepository, times(1)).findAll();
//     }

//     @Test
//     public void testUpdateProduct() {
//         // Arrange
//         ProductDTO productDTO = new ProductDTO();
//         productDTO.setInternalName("exampleInternalName"); // Set a sample internal name
//         Product existingProduct = new Product();

//         // Adjust the stubbing to match the specific internal name from the productDTO
//         when(productRepository.getProductEntityByInternalName(productDTO.getInternalName())).thenReturn(existingProduct);
//         when(productRepository.save(any(Product.class))).thenReturn(existingProduct);

//         // Act
//         ProductDTO result = productService.updateProduct(productDTO);

//         // Assert
//         assertNotNull(result);
//         verify(productRepository, times(1)).getProductEntityByInternalName(productDTO.getInternalName());
//         verify(productRepository, times(1)).save(any(Product.class));
//     }

//     @Test
//     public void testDeleteProduct() {
//         // Arrange
//         String internalName = "testInternalName";
//         Product existingProduct = new Product();
//         when(productRepository.getProductEntityByInternalName(anyString())).thenReturn(existingProduct);
//         doNothing().when(productRepository).delete(existingProduct);

//         // Act
//         productService.deleteProduct(internalName);

//         // Assert
//         verify(productRepository, times(1)).getProductEntityByInternalName(internalName);
//         verify(productRepository, times(1)).delete(existingProduct);
//     }


//     @Test
//     void testGetProductEntityByInternalName() {
//         // Arrange
//         String internalName = "exampleInternalName";
//         Product expectedProduct = new Product();
//         when(productRepository.getProductEntityByInternalName(internalName)).thenReturn(expectedProduct);

//         // Act
//         Product actualProduct = productService.getProductEntityByInternalName(internalName);

//         // Assert
//         assertNotNull(actualProduct);
//         assertEquals(expectedProduct, actualProduct);
//     }

//     @Test
//     void testConvertFeatureEntityToDTO() {
//         // Arrange
//         Feature feature = new Feature();
//         feature.setName("Test Feature");
//         feature.setInternalName("test-feature");

//         // Act
//         FeatureDTO result = productService.convertFeatureEntityToDTO(feature);

//         // Assert
//         assertNotNull(result);
//         assertEquals(feature.getName(), result.getName());
//         assertEquals(feature.getInternalName(), result.getInternalName());
//         // Add additional assertions based on your FeatureDTO structure
//     }

//     @Test
//     void testGetProductEntityById() {
//         // Arrange
//         Long productId = 1L;
//         Product expectedProduct = new Product();
//         expectedProduct.setId(productId);
//         expectedProduct.setInternalName("test-product");

//         // Adjust the stubbing to match the specific product ID
//         when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(expectedProduct));

//         // Act
//         Product result = productService.getProductEntityById(productId);

//         // Assert
//         assertNotNull(result);
//         assertEquals(expectedProduct.getId(), result.getId());
//         assertEquals(expectedProduct.getInternalName(), result.getInternalName());
//         // Add additional assertions based on your Product entity structure
//     }

//     // @Test
//     // void testGetFeaturesByProductInternalName() {
//     //     // Arrange
//     //     String internalName = "test-product";
//     //     Product product = new Product();
//     //     product.setInternalName(internalName);

//     //     Feature feature1 = new Feature();
//     //     feature1.setName("Feature 1");

//     //     Feature feature2 = new Feature();
//     //     feature2.setName("Feature 2");

//     //     // Set the features for the product
//     //     product.setFeatures(Arrays.asList(feature1, feature2));

//     //     // Adjust the stubbing to match the specific internal name
//     //     when(featureRepository.findByProduct_InternalName(internalName)).thenReturn(product.getFeatures());

//     //     // Act
//     //     List<FeatureDTO> result = productService.getFeaturesByProductInternalName(internalName);

//     //     // Assert
//     //     assertNotNull(result);
//     //     assertEquals(product.getFeatures().size(), result.size());
//     //     // Add additional assertions based on your FeatureDTO structure
//     // }

//     @Test
//     void testGetFeaturesByProductInternalNameWithoutFeatures() {
//         // Arrange
//         String internalName = "test-product";
//         Product product = new Product();
//         product.setInternalName(internalName);

//         // Set the features for the product as an empty list
//         product.setFeatures(Collections.emptyList());

//         // Adjust the stubbing to match the specific internal name
//         when(featureRepository.findByProduct_InternalName(internalName)).thenReturn(product.getFeatures());

//         // Act
//         List<FeatureDTO> result = productService.getFeaturesByProductInternalName(internalName);

//         // Assert
//         assertNotNull(result);
//         assertEquals(0, result.size());
//     }

//     @Test
//     void testGetFeaturesByProductInternalNameWithNullFeatures() {
//         // Arrange
//         String internalName = "test-product";
//         Product product = new Product();
//         product.setInternalName(internalName);

//         // Set the features for the product as null
//         product.setFeatures(null);

//         // Adjust the stubbing to match the specific internal name
//         when(featureRepository.findByProduct_InternalName(internalName)).thenReturn(null);

//         // Act
//         List<FeatureDTO> result = productService.getFeaturesByProductInternalName(internalName);

//         // Assert
//         assertNotNull(result);
//         assertEquals(0, result.size());
//     }

// }

