package com.itsherman.web.javagenerator.exception;

public class ConvertTypeException extends RuntimeException {

    public ConvertTypeException() {
    }

    public ConvertTypeException(String message) {
        super(message);
    }

    public ConvertTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertTypeException(Throwable cause) {
        super(cause);
    }
}
