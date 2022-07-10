package com.learning.restfulwebservices.exception;

import org.springframework.http.HttpStatus;

public enum Error {

    USER_NOT_FOUND_BY_ID("EC-001", "User not present with requested id", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    Error(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
