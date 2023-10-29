// package com.learnings.capstone.business;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.learnings.capstone.entity.Users;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// @SpringBootTest
// @ExtendWith(MockitoExtension.class)
// public class AuthAspectTest {

//     @InjectMocks
//     private AuthAspect authAspect;

//     @Mock
//     private LoggedInUser loggedInUser;

//     @Test
//     public void testDemandLoginWithLoggedInUser() throws Throwable {
//         // Arrange
//         ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
//         NeedsAuth needsAuth = mock(NeedsAuth.class);
//         when(loggedInUser.getLoggedInUser()).thenReturn(new Users()); // Assuming Users is the user class

//         // Act
//         Object result = authAspect.demandLogin(pjp, needsAuth);

//         // Assert
//         verify(pjp, times(1)).proceed();
//         // Add additional assertions based on your needs
//     }

//     @Test
//     public void testDemandLoginWithoutLoggedInUser() throws Throwable {
//         // Arrange
//         ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
//         NeedsAuth needsAuth = mock(NeedsAuth.class);
//         when(loggedInUser.getLoggedInUser()).thenReturn(null);

//         // Act
//         Object result = authAspect.demandLogin(pjp, needsAuth);

//         // Assert
//         // Assuming that the result is a redirect string
//         assertEquals("redirect:" + needsAuth.loginPage(), result);
//         // Add additional assertions based on your needs
//     }
// }
