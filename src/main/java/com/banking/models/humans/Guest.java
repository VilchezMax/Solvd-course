package com.banking.models.humans;

import com.banking.models.Tier;
import com.banking.models.humans.Adult;

public class Guest extends Adult {
    //ATTRIBUTES
    private boolean elegibilityForCredit=false;
    Tier tier = Tier.GUEST;

    //CONSTRUCTORS
    public Guest(String name, int age, int idNumber, String occupation, int creditScore) {
        super(name, age, idNumber, occupation, creditScore);
    }

    //SETTERS & GETTERS

    public boolean isElegibilityForCredit() {
        return elegibilityForCredit;
    }

    public void setElegibilityForCredit(boolean elegibilityForCredit) {
        this.elegibilityForCredit = elegibilityForCredit;
    }

    //METHODS

}
