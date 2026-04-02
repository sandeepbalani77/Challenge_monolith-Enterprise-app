package com.mycompany.entapp.snowman.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnowmanExceptionTest {

    @Test
    void testConstructorWithMessage() {
        SnowmanException ex = new SnowmanException("snowman error");
        assertEquals("snowman error", ex.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        Throwable cause = new RuntimeException("root");
        SnowmanException ex = new SnowmanException("snowman error", cause);
        assertEquals("snowman error", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testInheritsFromBusinessException() {
        SnowmanException ex = new SnowmanException("test");
        assertInstanceOf(BusinessException.class, ex);
    }
}
