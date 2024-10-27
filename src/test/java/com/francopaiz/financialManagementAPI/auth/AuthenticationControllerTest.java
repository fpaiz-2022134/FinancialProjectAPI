/*
package com.francopaiz.financialManagementAPI.auth;

import com.francopaiz.financialManagementAPI.controller.auth.AuthenticationController;
import com.francopaiz.financialManagementAPI.service.auth.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authController;

    private Map<String, String> credentials;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        credentials = new HashMap<>();
        credentials.put("email", "test@example.com");
        credentials.put("password", "password123");
    }

    @Test
    void testLogin_Success() {
        // Arrange
        String token = "mockToken";
        when(authenticationService.login("test@example.com", "password123")).thenReturn(token);

        // Act
        String result = authController.login(credentials);

        // Assert
        assertEquals(token, result);
        verify(authenticationService, times(1)).login("test@example.com", "password123");
    }

    @Test
    void testLogin_InvalidCredentials() {
        // Arrange
        when(authenticationService.login("test@example.com", "wrongPassword"))
                .thenThrow(new RuntimeException("Invalid credentials"));
        credentials.put("password", "wrongPassword");

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authController.login(credentials);
        });

        assertEquals("Invalid credentials", exception.getMessage());
        verify(authenticationService, times(1)).login("test@example.com", "wrongPassword");
    }

}*/
