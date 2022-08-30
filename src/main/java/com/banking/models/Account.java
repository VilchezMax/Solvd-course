package com.banking.models;

import com.banking.models.humans.Client;

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

    public Account(int accountID, Tier tier, double balance, Client client) {
        this.accountID = accountID;
        this.tier = tier;
        this.balance = balance;
        this.client = client;
    }


    //GETTERS & SETTERS

    //Finds index of accountID in the Bank's list of accounts.
    public static Account findAccountByID(Bank bank, int accountID) {
        Account account;
        for (Account acc : bank.getAccountList()) {
            if (acc.getAccountID() == accountID) {
                account = bank.getAccountList().indexOf(acc);
            }
        }
        return account;
    }

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

    //METHODS

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountID == account.accountID;
    }

    //Finds highest ID in Bank list
//    public static int findMaxID(ArrayList<Account> accList) {
//        int max = 0;
//        for (Account acc : accList) {
//            if (acc.getAccountID() > max) {
//                max = acc.getAccountID();
//            }
//        }
//        return max;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
