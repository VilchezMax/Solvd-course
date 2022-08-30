package com.banking.models.humans;

import com.banking.models.OccupationField;
import com.banking.models.Seniority;

public class Guest extends Adult {
    //ATTRIBUTES
    private boolean elegibilityForCredit = false;
    // Tier tier = Tier.GUEST; TODO: DEFINE IF GUESTS GET A TIER.

    //CONSTRUCTORS
    public Guest(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore);
    }

    //SETTERS & GETTERS

    public boolean isElegibileForCredit() {
        return elegibilityForCredit;
    }

    public void setElegibilityForCredit(boolean elegibilityForCredit) {
        this.elegibilityForCredit = elegibilityForCredit;
    }

    //METHODS

}
