package com.banking.exceptions;
//TODO: USE IN MAIN -  WHEN CHOOSING OPERATION IN SWITCH MENU
public class InvalidOperationException extends RuntimeException{
    public InvalidOperationException(){
        super("InvalidOperationException, you have to choose a valid operation");
    }
}
