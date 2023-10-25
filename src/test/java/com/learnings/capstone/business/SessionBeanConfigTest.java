package com.learnings.capstone.business;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = SessionBeanConfig.class)
@ComponentScan(basePackages = "com.learnings.capstone.business")
public class SessionBeanConfigTest {

    @Autowired
    private LoggedInUser loggedInUser;

    @Test
    public void testLoggedInUserBean() {
        assertNotNull(loggedInUser);
    }
}
