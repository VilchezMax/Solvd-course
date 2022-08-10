package com.banking.models;

public class Deposit extends Operation{
    //ATTRIBUTES
    int destinationAccountID;

    //CONSTRUCTOR
    public Deposit(int destinationAccountID) {
        super();
        this.destinationAccountID = destinationAccountID;
    }


    //SETTERS & GETTERS
    public int getDestinationAccountID() {
        return destinationAccountID;
    }

    public void setDestinationAccountID(int destinationAccountID) {
        this.destinationAccountID = destinationAccountID;
    }

    //METHODS
    public void deposit(){
        Account acc = Bank.getAccountList().get(Account.findIndexByID(this.destinationAccountID));
        acc.setBalance(acc.getBalance()+this.getAmount());
        this.setAmount(0);
    }
}
