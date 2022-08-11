package com.banking.models;


import com.banking.models.humans.Client;

import java.util.ArrayList;
import java.util.Objects;

public class Account {
    //ATTRIBUTES
    private int accountID;
    private Tier tier;
    private double balance;
    private Client client = null;

    //CONSTRUCTOR
    public Account(int accountID) {
        this.accountID = accountID;
        this.tier = Tier.BRONZE;
        this.balance = 0;
    }

    public Account(int accountID, Tier tier, double balance) {
        this.accountID = accountID;
        this.tier = tier;
        this.balance = balance;
    }


    //GETTERS & SETTERS

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public double getBalance() {
        return balance;
    }

    public double setBalance(double balance) {
        this.balance = balance;
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //METHODS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountID == account.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }

    //Finds highest ID in Bank list
    public static int findMaxID(ArrayList<Account> list) {
        int max = 0;
        for (Account acc : list) {
            if (acc.getAccountID() > max) {
                max = acc.getAccountID();
            }
        }
        return max;
    }

    //Finds index of accountID in the Bank's list of accounts.
    public static int findIndexByID(int accountID) {
        int index = -1;
        for (Account acc : Bank.getAccountList()) {
            if (acc.getAccountID() == accountID) {
                index = Bank.getAccountList().indexOf(acc);
            }
        }
        return index;
    }
}
