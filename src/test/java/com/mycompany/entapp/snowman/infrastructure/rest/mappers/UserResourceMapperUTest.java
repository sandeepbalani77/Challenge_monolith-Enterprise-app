package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceMapperUTest {

    @Test
    void testMapUserToResource() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setFirstname("First");
        user.setLastname("Last");
        UserResource resource = UserResourceMapper.mapUserToUserResource(user);
        assertEquals(1, resource.getUserId());
        assertEquals("testuser", resource.getUsername());
        assertEquals("test@example.com", resource.getEmail());
    }

    @Test
    void testMapResourceToUser() {
        UserResource resource = new UserResource();
        resource.setUserId(1);
        resource.setUsername("testuser");
        resource.setFirstName("First");
        resource.setSecondName("Last");
        User user = UserResourceMapper.mapUserResourceToUser(resource);
        assertEquals(1, user.getUserId());
        assertEquals("testuser", user.getUsername());
    }
}
