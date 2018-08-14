package com.example.demo.exceptions;

public class GuidException extends RuntimeException {

    public GuidException(String message) {
        super(message);
    }

    public GuidException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuidException(Throwable cause) {
        super(cause);
    }
}
