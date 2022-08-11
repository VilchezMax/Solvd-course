package com.banking.models;

public class Transfer extends Operation{
         //ATTRIBUTES
        int originAccountID;
        int destinationAccountID;
        double maxAmount;

        //CONSTRUCTOR

    public Transfer(int originAccountID, int destinationAccountID) {
            this.originAccountID = originAccountID;
            this.destinationAccountID = destinationAccountID;
            this.maxAmount = Bank.getAccountList().get(Account.findIndexByID(originAccountID)).getBalance();;
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
    public void transfer(double amount){
            Account accOrigin=Bank.getAccountList().get(
                              Account.findIndexByID(originAccountID));
            Account accDestination=Bank.getAccountList().get(
                              Account.findIndexByID(destinationAccountID));
            if (amount<this.maxAmount){
                accOrigin.setBalance(accOrigin.getBalance()-amount);
                accDestination.setBalance(accDestination.getBalance()+amount);
            } else {
                throw new IllegalArgumentException("Amount transferred can't be larger than account balance");
            }
    }
}
