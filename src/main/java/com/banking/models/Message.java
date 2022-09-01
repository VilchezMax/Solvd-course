package com.banking.models;

public enum Message {
    GREETING("¡ Welcome to our bank !"),
    FAREWELL("¡ Thank you for trusting us ! Come again soon.");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String emphaticMessage() {
        return this.getMessage().toUpperCase();
    }
}
