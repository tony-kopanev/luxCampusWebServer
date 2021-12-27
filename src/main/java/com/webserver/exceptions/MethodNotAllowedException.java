package com.webserver.exceptions;

public class MethodNotAllowedException extends RuntimeException {

    public MethodNotAllowedException(String message) {
        super(message);
    }
}
