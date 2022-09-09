package com.banking.exceptions;

public class UnregisteredException extends Exception {
    public UnregisteredException() {
        super("UnregisteredException, this is not on the bank database");
    }
}
