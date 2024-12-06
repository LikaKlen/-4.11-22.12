package org.example.exceptions;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException(String message) {
        super(message);
    }
}
