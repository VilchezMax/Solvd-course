package com.banking.models.humans;

import com.banking.interfaces.ISignUp;
import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;
import com.banking.models.Tier;

public class Guest extends Person implements ISignUp {
    //ATTRIBUTES
    private final boolean elegibilityForCredit;
    private final Tier tier;

    //CONSTRUCTORS
    public Guest(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore);
        this.elegibilityForCredit = false;
        this.tier = Tier.GUEST;
    }

    //SETTERS & GETTERS

    public boolean getElegibilityForCredit() {
        return elegibilityForCredit;
    }

    public Tier getTier() {
        return tier;
    }

    //METHODS

    public void signUp(Bank bank) {
        bank.signUp(this);
    }
}
