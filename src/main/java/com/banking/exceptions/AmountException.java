package com.banking.exceptions;

public class AmountException extends RuntimeException{
    public AmountException(){
        super("InvalidAmountException, The amount chosen is larger than available");
    }
}
