package com.banking.models.humans;


import com.banking.exceptions.UnregisteredException;
import com.banking.interfaces.IResign;
import com.banking.models.Bank;

public class BankWorker extends Person implements IResign {
    double wage;

    public BankWorker(){
        super();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public void resign() throws UnregisteredException {
        if(Bank.getBankWorkerSet().contains(this)){
            Bank.getBankWorkerSet().remove(this);
            this.setWage(0);
        } else {
            throw new UnregisteredException();
        }
    }
}
