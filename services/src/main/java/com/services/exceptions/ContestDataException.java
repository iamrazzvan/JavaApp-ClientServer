package com.services.exceptions;

public class ContestDataException extends Exception {
    public ContestDataException() {
    }

    public ContestDataException(String message) {
        super(message);
    }

    public ContestDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
