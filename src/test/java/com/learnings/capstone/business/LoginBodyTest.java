package com.learnings.capstone.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginBodyTest {

    @Test
    public void testGetSetUsername() {
        // Arrange
        LoginBody loginBody = new LoginBody();
        String username = "test-username";

        // Act
        loginBody.setUsername(username);
        String retrievedUsername = loginBody.getUsername();

        // Assert
        assertEquals(username, retrievedUsername);
    }

    @Test
    public void testGetSetPassword() {
        // Arrange
        LoginBody loginBody = new LoginBody();
        String password = "test-password";

        // Act
        loginBody.setPassword(password);
        String retrievedPassword = loginBody.getPassword();

        // Assert
        assertEquals(password, retrievedPassword);
    }
}
