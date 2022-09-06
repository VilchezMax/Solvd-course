package com.banking.models.humans;


import com.banking.exceptions.UnregisteredException;
import com.banking.interfaces.IResign;
import com.banking.models.*;

import java.util.Objects;

public class Client extends Person implements IResign {
    //ATTRIBUTES
    private final int clientID;
    private final Account account;
    private Bank bank;
    private boolean eligibilityForCredit;

    //CONSTRUCTORS
    public Client(Bank bank) {
        super();
        this.bank = bank;
        this.clientID = this.hashCode();
        this.account = new Account();
        this.eligibilityForCredit = checkEligibilityForCredit();
    }

    public Client(Account account, Bank bank) {
        super();
        this.bank = bank;
        this.clientID = this.hashCode();
        this.account = account;
        this.bank = bank;
        this.eligibilityForCredit = checkEligibilityForCredit();
    }

    public Client(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, Account account, Bank bank) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore);
        this.clientID = this.hashCode();
        this.account = account;
        this.bank = bank;
        this.eligibilityForCredit = checkEligibilityForCredit();
    }

    public Client(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, Account account) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore);
        this.clientID = this.hashCode();
        this.account = account;
        this.eligibilityForCredit = checkEligibilityForCredit();
    }

    //SETTERS & GETTERS

    public int getClientID() {
        return clientID;
    }

    public Account getAccount() {
        return account;
    }

    public void setEligibilityForCredit(boolean eligibilityForCredit) {
        this.eligibilityForCredit = eligibilityForCredit;
    }

    //METHODS

    public Tier getAccountTier() {
        return this.getAccount().getTier();
    }

    public boolean checkEligibilityForCredit() {
        boolean isElegible = false;
        Tier tier = this.getAccountTier();

        if (tier != Tier.BRONZE || this.getCreditScore() > 50) {
            isElegible = true;
        }
        return isElegible;
    }

    @Override
    public void resign() throws UnregisteredException {
        bank.clearAccount(this.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdNumber());
    }
}
