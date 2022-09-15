package com.banking.exceptions;

public class AmountException extends Exception {

    public AmountException() {
        super("InvalidAmountException, The amount chosen is larger than available");
    }
}
