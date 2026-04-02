package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.service.UserService;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRestEndpointUTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRestEndpoint endpoint;

    @Test
    void testGetUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("testuser");
        when(userService.getUser(1)).thenReturn(user);
        ResponseEntity<UserResource> response = endpoint.getUser(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetUserNotFound() {
        when(userService.getUser(99)).thenReturn(null);
        ResponseEntity<UserResource> response = endpoint.getUser(99);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteUser() {
        ResponseEntity<Void> response = endpoint.deleteUser(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService).deleteUser(1);
    }
}
