package com.banking.models.humans;

import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;

public final class BankTeller extends BankWorker {
    public BankTeller(Bank bank) {
        super(bank);
    }

    public BankTeller(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, double wage, Bank bank) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore, wage, bank);
    }

//Attributes
//TODO
    //Constructors

    //Setters & Getters

    //Methods
}
