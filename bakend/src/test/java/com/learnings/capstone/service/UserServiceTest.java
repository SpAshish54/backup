package com.learnings.capstone.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnings.capstone.entity.Product;
import com.learnings.capstone.entity.Users;
import com.learnings.capstone.repository.UserRepository;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testAuthenticateUserFoundAndPasswordMatch() {
        
        String username = "testUser";
        String password = "password";
        Users user = new Users();
        user.setName(username);
        user.setPassword(password);

        when(userRepository.findByName(username)).thenReturn(Optional.of(user));

        
        Optional<Users> result = userService.authenticate(username, password);

        
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    

    @Test
    void testAuthenticateUserFoundAndPasswordMismatch() {
        
        String username = "testUser";
        String password = "password";
        Users user = new Users();
        user.setName(username);
        user.setPassword("differentPassword");

        when(userRepository.findByName(username)).thenReturn(Optional.of(user));

        
        Optional<Users> result = userService.authenticate(username, password);

        
        assertFalse(result.isPresent());
    }

    @Test
    void testCreateUser() {
        
        Users user = new Users();
        user.setName("testUser");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        
        Users createdUser = userService.create(user);

        
        assertEquals(user, createdUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetById() {
        
        long userId = 1L;
        Users user = new Users();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        
        Optional<Users> result = userService.getById(userId);

        
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testGetByName() {
        
        String username = "testUser";
        Users user = new Users();
        user.setName(username);

        when(userRepository.findByName(username)).thenReturn(Optional.of(user));

        
        Optional<Users> result = userService.getByName(username);

        
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testGetProduct() {
        // Arrange
        Users user = new Users();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        productList.add(product1);
        productList.add(product2);
        user.setProduct(productList);

        // Act
        List<Product> result = user.getProduct();

        // Assert
        assertEquals(productList, result);
    }

    @Test
    void testSetProduct() {
        // Arrange
        Users user = new Users();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        productList.add(product1);
        productList.add(product2);

        // Act
        user.setProduct(productList);

        // Assert
        assertEquals(productList, user.getProduct());
    }
}

