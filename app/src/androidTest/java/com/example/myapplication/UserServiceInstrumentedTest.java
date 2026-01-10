package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Instrumented test demonstrating Mockito usage in Android tests.
 * This test runs on an Android device or emulator.
 */
public class UserServiceInstrumentedTest {

    @Mock
    private UserRepository mockRepository;

    private UserService userService;
    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        userService = new UserService(mockRepository);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testServiceWithMockedRepository() {
        // Arrange
        when(mockRepository.isUserValid(42)).thenReturn(true);
        when(mockRepository.getUserName(42)).thenReturn("Android User");

        // Act
        String result = userService.getDisplayName(42);

        // Assert
        assertEquals("Hello, Android User", result);
        verify(mockRepository).isUserValid(42);
        verify(mockRepository).getUserName(42);
    }

    @Test
    public void testInvalidUserOnAndroid() {
        // Arrange
        when(mockRepository.isUserValid(0)).thenReturn(false);

        // Act
        String result = userService.getDisplayName(0);

        // Assert
        assertEquals("Invalid User", result);
    }
}
