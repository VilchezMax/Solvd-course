package com.banking.models.humans;


import com.banking.exceptions.UnregisteredException;
import com.banking.interfaces.IResign;
import com.banking.models.Account;
import com.banking.models.Bank;
import com.banking.models.Tier;

public class Client extends Adult implements IResign {
    //ATTRIBUTES
    private Bank bank;
    private final int clientID;
    private final Account account;
    private boolean eligibilityForCredit;

    //CONSTRUCTORS
    public Client(Bank bank, int clientID) {
        super();
        this.bank = bank;
        this.clientID = clientID;
        this.account = new Account(bank.newAccountId());
        this.eligibilityForCredit =

    }

    public Client(String name, int age, int idNumber, String occupation, int creditScore, int clientID) {
        super(name, age, idNumber, occupation, creditScore);
        this.clientID = clientID;
        this.account = new Account(bank.newAccountId());
        this.eligibilityForCredit =
    }

    //SETTERS & GETTERS

    public int getClientID() {
        return clientID;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isEligibilityForCredit() {
        return eligibilityForCredit;
    }

    public void setEligibilityForCredit(boolean eligibilityForCredit) {
        this.eligibilityForCredit = eligibilityForCredit;
    }

    //METHODS

    public Tier getAccountTier() {
        Tier tier = this.getAccount().getTier();
        return tier;
    }

    public boolean checkEligibilityForCredit() {
        boolean isElegible = false;
        Tier tier = this.getAccountTier();

        if (tier != Tier.BRONZE || this.getCreditScore() > 50) {
            isElegible = true;
            System.out.println("With a creditScore of " + this.getCreditScore() + " and a " + tier + " account," + "\n"
                    + this.getName() + " is elegible for a credit." + "\n"
                    + "Your tier grants you a discount on interest payments of -"
                    + tier.getInterestDisc() + "%");
        }
        return isElegible;
    }

    //TODO: THIS LOGIC BELONGS TO BANK. FROM HERE ONLY CALL BANK METHODS.
    @Override
    public void resign() throws UnregisteredException {
        //solvdBank.clearAccount(this.getAccount)

//        if () {
//            Bank.getAccountList().remove(this);
//        }
//        if (Bank.getAccountIDClientMap().containsKey(Integer.valueOf(this.getAccount()))) {
//            Bank.getAccountIDClientMap().remove(Integer.valueOf(this.getAccount()), this);
//        }
    }
}
