package com.calopsite.demo.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductTypeException extends ResponseStatusException {
    private String message;

    public ProductTypeException(HttpStatus status, String message) {
        super(status);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
