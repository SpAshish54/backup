package com.learnings.capstone.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.learnings.capstone.dto.FeatureDTO;
import com.learnings.capstone.dto.ProductDTO;
import com.learnings.capstone.entity.Feature;
import com.learnings.capstone.entity.Product;
import com.learnings.capstone.entity.Users;
import com.learnings.capstone.exception.CatalogBusinessException;
import com.learnings.capstone.repository.ProductRepository;
import com.learnings.capstone.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired 
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void addProduct(ProductDTO productDTO) {
        Product product = convertDTOToEntity(productDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Users> loggedinUser = userRepository.findByName(username);

        // Initialize the list if it's null
        if (loggedinUser.get().getProduct() == null) {
            loggedinUser.get().setProduct(new ArrayList<>());
        }

        product.setUserId(loggedinUser.get().getId());
        loggedinUser.get().getProduct().add(product);
        userRepository.save(loggedinUser.get());
        productRepository.save(product);
    }


    public ProductDTO getProductById(Long productId) {
        Product product = getProductEntityById(productId);
        return convertEntityToDTO(product);
    }

    public ProductDTO getProductByInternalName(String productInternalName ) {
        Product product = getProductEntityByInternalName(productInternalName);
        return convertEntityToDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertEntityToDTO)
                .toList();
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product existingProduct = productRepository.getProductEntityByInternalName(productDTO.getInternalName());
    
        if (existingProduct == null) {
            throw new CatalogBusinessException("Product not found with internal name: " + productDTO.getInternalName());
        }
    
        updateProductFromDTO(existingProduct, productDTO);
        productRepository.save(existingProduct);
    
        return convertEntityToDTO(existingProduct);
    }
    
    public void deleteProduct(String productInternalName) {
        Product existingProduct = productRepository.getProductEntityByInternalName(productInternalName);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Users> loggedinUserOptional = userRepository.findByName(username);
    
        // Ensure the user is present
        if (loggedinUserOptional.isPresent()) {
            Users loggedinUser = loggedinUserOptional.get();
    
            // Initialize the list if it's null
            if (loggedinUser.getProduct() == null) {
                loggedinUser.setProduct(new ArrayList<>());
            }
    
            // Remove the product only if it exists in the list
            if (loggedinUser.getProduct().contains(existingProduct)) {
                loggedinUser.getProduct().remove(existingProduct);
                userRepository.save(loggedinUser);
            }
        }
    
        productRepository.delete(existingProduct);
    }
        
    

    private Product convertDTOToEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }

    private ProductDTO convertEntityToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    private void updateProductFromDTO(Product product, ProductDTO productDTO) {
        BeanUtils.copyProperties(productDTO, product);
    }

    public Product getProductEntityById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CatalogBusinessException("Product not found with id " + productId));
    }

    public List<FeatureDTO> getFeaturesByProductInternalName(String internalName) {
        Product product = getProductEntityByInternalName(internalName);
    
        if (product != null && product.getFeatures() != null) {
            return product.getFeatures().stream()
                    .map(this::convertFeatureEntityToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
    
    

    public Product getProductEntityByInternalName(String internalName) {
        return productRepository.getProductEntityByInternalName(internalName);
    }

    public FeatureDTO convertFeatureEntityToDTO(Feature feature) {
        FeatureDTO featureDTO = new FeatureDTO();
        BeanUtils.copyProperties(feature, featureDTO);
        return featureDTO;
    }
}
