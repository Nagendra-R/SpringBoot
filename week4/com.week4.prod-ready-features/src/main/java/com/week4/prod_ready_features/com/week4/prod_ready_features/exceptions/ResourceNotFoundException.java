package com.week4.prod_ready_features.com.week4.prod_ready_features.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
