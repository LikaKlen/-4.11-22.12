package org.example.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private Map<String, String> fieldErrors;

    public ErrorResponse(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorResponse(LocalDateTime timestamp, String message, Map<String, String> fieldErrors) {
        this.timestamp = timestamp;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

}