package com.mycompany.entapp.snowman.domain.exception;

public class SnowmanException extends BusinessException {

    public SnowmanException(String message) {
        super(message);
    }

    public SnowmanException(String message, Throwable cause) {
        super(message, cause);
    }
}
