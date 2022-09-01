package com.banking.models;

public enum Message {
    GREETING("Welcome to our bank!"),
    FAREWELL("Thank you for ");

    private String message;

    private Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String emphaticMessage(Message msg){
        return StringUtils.toU
    }
}
