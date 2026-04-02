package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplUTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("testuser");
        when(userRepository.findUser(1)).thenReturn(user);
        User result = userService.getUser(1);
        assertEquals("testuser", result.getUsername());
    }

    @Test
    void testCreateUser() {
        User user = new User();
        userService.createUser(user);
        verify(userRepository).saveUser(user);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        userService.updateUser(user);
        verify(userRepository).saveUser(user);
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1);
        verify(userRepository).removeUser(1);
    }
}
