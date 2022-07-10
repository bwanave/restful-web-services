package com.learning.restfulwebservices.dto;

import java.time.ZonedDateTime;

public class ExceptionResponse {
    private final String code;
    private final String message;
    private final ZonedDateTime timestamp;

    public ExceptionResponse(String code, String message, ZonedDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
