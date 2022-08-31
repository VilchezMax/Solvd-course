package com.banking.models.humans;

import com.banking.interfaces.ISignUp;
import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;

public class Adult extends Person implements ISignUp {
    //ATTRIBUTES
    private OccupationField occupation;
    private Seniority jobSeniority;
    private int creditScore;

    //CONSTRUCTORS
    public Adult() {
        super();
        this.occupation = OccupationField.UNEMPLOYED;
        this.jobSeniority = null;
        if (this.getOccupation().equals(OccupationField.UNEMPLOYED)) {
            this.creditScore = 0;
        } else {
            this.creditScore = 10;
        }
    }

    public Adult(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore) {
        super(name, age, idNumber);
        this.occupation = occupation;
        if (!this.getOccupation().equals(OccupationField.UNEMPLOYED)) {
            this.creditScore = creditScore;
            this.jobSeniority = jobSeniority;
        } else {
            this.creditScore = 0;
            this.jobSeniority = null;
        }
    }

    //SETTERS & GETTERS

    public OccupationField getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationField occupation) {
        this.occupation = occupation;
    }

    public Seniority getJobSeniority() {
        return jobSeniority;
    }

    public void setJobSeniority(Seniority jobSeniority) {
        this.jobSeniority = jobSeniority;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public void signUp(Bank bank) {
        bank.signingUp(this);
    }


    //METHODS
}
