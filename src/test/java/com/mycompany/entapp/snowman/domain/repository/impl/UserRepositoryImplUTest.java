package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplUTest {

    @Mock
    private UserJpaRepository userJpaRepository;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    void testFindUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("test");
        when(userJpaRepository.findById(1)).thenReturn(Optional.of(user));
        User result = userRepository.findUser(1);
        assertEquals("test", result.getUsername());
    }

    @Test
    void testFindUserNotFound() {
        when(userJpaRepository.findById(99)).thenReturn(Optional.empty());
        assertNull(userRepository.findUser(99));
    }

    @Test
    void testSaveUser() {
        User user = new User();
        userRepository.saveUser(user);
        verify(userJpaRepository).save(user);
    }

    @Test
    void testRemoveUser() {
        userRepository.removeUser(1);
        verify(userJpaRepository).deleteById(1);
    }
}
