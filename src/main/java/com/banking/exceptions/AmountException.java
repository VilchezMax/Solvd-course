package com.banking.exceptions;

import com.banking.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AmountException extends Exception{

    public AmountException(){
        super("InvalidAmountException, The amount chosen is larger than available");
    }
}
