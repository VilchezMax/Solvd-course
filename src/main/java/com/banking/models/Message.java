package com.banking.models;

public enum Message {

    GREETING {
        @Override
        public String getMessage() {
            return "¡ Welcome to our bank !";
        }
    },
    FAREWELL {
        @Override
        public String getMessage() {
            return "¡ Thank you for trusting us ! Come again soon.";
        }
    };


    private Message() {
    }

    public abstract String getMessage();

}
