package com.learnings.capstone.business;

import com.learnings.capstone.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoggedInUserTest {

    @Test
    void testGetSetLoggedInUser() {
        // Arrange
        LoggedInUser loggedInUserObj = new LoggedInUser();

        // Create a Users object
        Users user = new Users();
        user.setId(1L);
        user.setName("testuser");
        user.setPassword("testpassword");
        user.setRole("USER");

        // Act
        loggedInUserObj.setLoggedInUser(user);

        // Assert
        assertEquals(user, loggedInUserObj.getLoggedInUser());
    }
}
