package com.mycompany.entapp.snowman.infrastructure.rest;

import com.mycompany.entapp.snowman.domain.exception.BusinessException;
import com.mycompany.entapp.snowman.domain.exception.SnowmanException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerUTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleSnowmanException() {
        SnowmanException ex = new SnowmanException("snowman error");
        ResponseEntity<Map<String, String>> response = handler.handleSnowman(ex);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("snowman error", response.getBody().get("error"));
    }

    @Test
    void testHandleBusinessException() {
        BusinessException ex = new BusinessException("business error");
        ResponseEntity<Map<String, String>> response = handler.handleBusiness(ex);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals("business error", response.getBody().get("error"));
    }

    @Test
    void testHandleRuntimeException() {
        RuntimeException ex = new RuntimeException("runtime error");
        ResponseEntity<Map<String, String>> response = handler.handleRuntime(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("runtime error", response.getBody().get("error"));
    }
}
