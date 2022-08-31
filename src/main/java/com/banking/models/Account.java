package com.banking.models;

import com.banking.exceptions.UnregisteredException;
import com.banking.models.humans.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Account {
    //ATTRIBUTES
    private int accountID;
    private Tier tier;
    private double balance;
    private Client client = null;


    //CONSTRUCTOR
    public Account() {
        this.accountID = Account.newAccountId();
        this.tier = Tier.BRONZE;
        this.balance = 0;
    }

    public Account(Tier tier, double balance) {
        this.accountID = Account.newAccountId();
        this.tier = tier;
        this.balance = balance;
    }

    public Account(int accountID, Tier tier, double balance, Client client) {
        this.accountID = accountID;
        this.tier = tier;
        this.balance = balance;
        this.client = client;
    }

    // GETTERS & SETTERS

    //METHODS
    public static Account findAccountByID(Bank bank, int accountID) {
        Account account = (Account) bank.getAccountList()
                .stream()
                .filter(acc -> acc.getAccountID() == accountID);

        if (account == null) {
            Throwable e = new UnregisteredException();
            final Logger logger = LogManager.getLogger(Operation.class);
            logger.warn("Operation " + accountID + " not found\n", e);
        }
        return account;
    }

    public static int newAccountId() {
        return Bank.generateAccountID();
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
