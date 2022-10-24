package com.company.hhuz.exceptions;

import lombok.Getter;

@Getter
public class GenericInvalidTokenException extends GenericNotFoundException {
    public GenericInvalidTokenException(String message, Throwable statusCode) {
        super(message, statusCode);
    }
}
