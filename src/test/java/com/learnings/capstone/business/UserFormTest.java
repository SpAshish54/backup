package com.learnings.capstone.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserFormTest {

    @Test
    public void testGetSetName() {
        // Arrange
        UserForm userForm = new UserForm();
        String name = "test-name";

        // Act
        userForm.setName(name);
        String retrievedName = userForm.getName();

        // Assert
        assertEquals(name, retrievedName);
    }

    @Test
    public void testGetSetPassword() {
        // Arrange
        UserForm userForm = new UserForm();
        String password = "test-password";

        // Act
        userForm.setPassword(password);
        String retrievedPassword = userForm.getPassword();

        // Assert
        assertEquals(password, retrievedPassword);
    }

    @Test
    public void testGetSetPasswordRepeat() {
        // Arrange
        UserForm userForm = new UserForm();
        String passwordRepeat = "test-password-repeat";

        // Act
        userForm.setPasswordRepeat(passwordRepeat);
        String retrievedPasswordRepeat = userForm.getPasswordRepeat();

        // Assert
        assertEquals(passwordRepeat, retrievedPasswordRepeat);
    }
}
