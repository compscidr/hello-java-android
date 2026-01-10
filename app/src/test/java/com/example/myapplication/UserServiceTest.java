package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockRepository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService(mockRepository);
    }

    @Test
    public void getDisplayName_withValidUser_returnsFormattedName() {
        // Arrange
        int userId = 123;
        when(mockRepository.isUserValid(userId)).thenReturn(true);
        when(mockRepository.getUserName(userId)).thenReturn("John Doe");

        // Act
        String result = userService.getDisplayName(userId);

        // Assert
        assertEquals("Hello, John Doe", result);
        verify(mockRepository).isUserValid(userId);
        verify(mockRepository).getUserName(userId);
    }

    @Test
    public void getDisplayName_withInvalidUser_returnsInvalidMessage() {
        // Arrange
        int userId = -1;
        when(mockRepository.isUserValid(userId)).thenReturn(false);

        // Act
        String result = userService.getDisplayName(userId);

        // Assert
        assertEquals("Invalid User", result);
        verify(mockRepository).isUserValid(userId);
    }
}
