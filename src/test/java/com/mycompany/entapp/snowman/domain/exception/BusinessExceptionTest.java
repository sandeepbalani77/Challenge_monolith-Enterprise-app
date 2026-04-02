package com.mycompany.entapp.snowman.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessExceptionTest {

    @Test
    void testConstructorWithMessage() {
        BusinessException ex = new BusinessException("test error");
        assertEquals("test error", ex.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        Throwable cause = new RuntimeException("root cause");
        BusinessException ex = new BusinessException("test error", cause);
        assertEquals("test error", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testIsException() {
        BusinessException ex = new BusinessException("test");
        assertInstanceOf(Exception.class, ex);
    }
}
