package com.banking.models;

public class Transfer extends Operation {
    //ATTRIBUTES
    int originAccountID;
    int destinationAccountID;
    double maxAmount;

    //CONSTRUCTOR

    public Transfer(Bank bank, int originAccountID, int destinationAccountID) {
        super(bank);
        this.originAccountID = originAccountID;
        this.destinationAccountID = destinationAccountID;
        this.maxAmount = Account.findAccountByID(bank, originAccountID).getBalance();
    }


    //SETTERS & GETTERS

    public int getOriginAccountID() {
        return originAccountID;
    }

    public void setOriginAccountID(int originAccountID) {
        this.originAccountID = originAccountID;
    }

    public int getDestinationAccountID() {
        return destinationAccountID;
    }

    public void setDestinationAccountID(int destinationAccountID) {
        this.destinationAccountID = destinationAccountID;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    //METHODS
    public void transfer(Bank bank, double amount) {
        Account accOrigin = Account.findAccountByID(bank, originAccountID);
        Account accDestination = Account.findAccountByID(bank, destinationAccountID);
        if (amount < this.maxAmount) {
            accOrigin.setBalance(accOrigin.getBalance() - amount);
            accDestination.setBalance(accDestination.getBalance() + amount);
        } else {
            throw new IllegalArgumentException("Amount transferred can't be larger than account balance");
        }
    }
}
