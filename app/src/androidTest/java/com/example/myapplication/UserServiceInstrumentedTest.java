package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Instrumented test demonstrating Mockito usage in Android tests.
 * This test runs on an Android device or emulator.
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceInstrumentedTest {

    @Mock
    private UserRepository mockRepository;

    private UserService userService;
    private Context appContext;

    @BeforeEach
    public void setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        userService = new UserService(mockRepository);
    }

    @Test
    public void testServiceWithMockedRepository() {
        // Verify we're running on Android
        assertEquals("com.example.myapplication", appContext.getPackageName());

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
