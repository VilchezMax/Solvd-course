package com.banking.exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException() {
        super("InvalidOperationException, you have to choose a valid operation");
    }
}
