package com.tte;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tte.dto.UserDTO;
import com.tte.dto.UserResponseRegisterDTO;
import com.tte.exception.CustomException;
import com.tte.model.User;
import com.tte.repository.UserRepository;
import com.tte.service.UserService;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService();
        userService.setUserRepository(userRepository);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("TestPass123");

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        when(userRepository.existsByEmail(userDTO.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserResponseRegisterDTO response = userService.crearUser(userDTO);

        assertNotNull(response);
        assertEquals(userDTO.getName(), response.getName());
        assertEquals(userDTO.getEmail(), response.getEmail());
     
    }

    @Test
    public void testCreateUserWithInvalidEmail() {
       
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("invalid-email"); // Invalid email format
        userDTO.setPassword("TestPass123");
 
        assertThrows(CustomException.class, () -> userService.crearUser(userDTO));
    }

    @Test
    public void testCreateUserWithExistingEmail() {
    
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("existing@example.com");
        userDTO.setPassword("TestPass123");

        when(userRepository.existsByEmail(userDTO.getEmail())).thenReturn(true);

    
        assertThrows(CustomException.class, () -> userService.crearUser(userDTO));
    }

    @Test
    public void testCreateUserWithInvalidPassword() {
       
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("weak"); // Invalid password format

      
        assertThrows(CustomException.class, () -> userService.crearUser(userDTO));
    }

    @Test
    public void testValidateFormatMail() {
  
        String validEmail = "test@example.com";
        String invalidEmail = "invalid-email";

        assertTrue(userService.validateFormatMail(validEmail));
        assertFalse(userService.validateFormatMail(invalidEmail));
    }

    @Test
    public void testMailRegister() {
    
        String existingEmail = "existing@example.com";
        String nonExistingEmail = "new@example.com";

        when(userRepository.existsByEmail(existingEmail)).thenReturn(true);
        when(userRepository.existsByEmail(nonExistingEmail)).thenReturn(false);

  
        assertTrue(userService.mailRegister(existingEmail));
        assertFalse(userService.mailRegister(nonExistingEmail));
    }

    @Test
    public void testValidateFormatPassword() {
        // Arrange
        String validPassword = "StrongPass123";
        String invalidPassword = "weak";

        // Act and Assert
        assertTrue(userService.validateFormatPassword(validPassword));
        assertFalse(userService.validateFormatPassword(invalidPassword));
    }
}
