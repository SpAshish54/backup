package com.learnings.capstone.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenDTOTest {

    @Test
    public void testGetSetToken() {
        // Arrange
        TokenDTO tokenDTO = new TokenDTO();
        String token = "test-token";

        // Act
        tokenDTO.setToken(token);
        String retrievedToken = tokenDTO.getToken();

        // Assert
        assertEquals(token, retrievedToken);
    }
}
