package com.banking.models.humans;


import com.banking.exceptions.UnregisteredException;
import com.banking.interfaces.IResign;
import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;

public class BankWorker extends Person implements IResign {
    private double wage;
    private Bank bank;


    public BankWorker(Bank bank) {
        super();
        this.bank = bank;
    }

    public BankWorker(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, double wage, Bank bank) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore);
        this.wage = wage;
        this.bank = bank;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void resign() throws UnregisteredException {
        /* TODO
        if(Bank.getBankWorkerSet().contains(this)){
            Bank.getBankWorkerSet().remove(this);
            this.setWage(0);
        } else {
            throw new UnregisteredException();
        }
        */

    }

}
