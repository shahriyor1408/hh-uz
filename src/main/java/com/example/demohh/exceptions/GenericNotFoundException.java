package com.example.demohh.exceptions;

public class GenericNotFoundException extends GenericRuntimeException {
    public GenericNotFoundException(String message, Integer statusCode) {
        super(message, statusCode);
    }
}
