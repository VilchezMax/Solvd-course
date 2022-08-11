package com.banking.models.humans;

import com.banking.interfaces.IResign;
import com.banking.models.Account;
import com.banking.models.Bank;
import com.banking.models.Tier;

public class Client extends Adult implements IResign {
    //ATTRIBUTES
    private final int clientID;
    private final int accountID;
    private boolean eligibilityForCredit;
    private String mainBranchAddress;

    //CONSTRUCTORS
    public Client(int clientID, boolean eligibilityForCredit, String mainBranchAddress) {
        this.clientID = clientID;
        this.accountID = Account.findMaxID(Bank.getAccountList()) + 1;
        this.eligibilityForCredit = eligibilityForCredit;
        this.mainBranchAddress = mainBranchAddress;
    }

    public Client(String name, int age, int idNumber, String occupation, int creditScore, int clientID, int accountID, boolean eligibilityForCredit, String mainBranchAddress) {
        super(name, age, idNumber, occupation, creditScore);
        this.clientID = clientID;
        this.accountID = accountID;
        this.eligibilityForCredit = eligibilityForCredit;
        this.mainBranchAddress = mainBranchAddress;
    }

    //SETTERS & GETTERS

    public int getClientID() {
        return clientID;
    }

    public int getAccountID() {
        return accountID;
    }

    public boolean isEligibilityForCredit() {
        return eligibilityForCredit;
    }

    public void setEligibilityForCredit(boolean eligibilityForCredit) {
        this.eligibilityForCredit = eligibilityForCredit;
    }

    public String getMainBranchAddress() {
        return mainBranchAddress;
    }

    public void setMainBranch(String mainBranchAddress) {
        this.mainBranchAddress = mainBranchAddress;
    }

    //METHODS
    /*
     * Checks creditScore of client/Tier of clients account to determine if its eligible for credit.
     * Access Banks account list, then searches for the account getting the index to search in the list
     * Then it evaluates the values
     */
    public static Tier getTierOfClientAccount(Client client) {
        Tier tier = Bank.getAccountList()
                .get(Account.findIndexByID(client.getAccountID()))
                .getTier();

        return tier;
    }

    public static boolean checkEligibilityForCredit(Client client) {
        boolean isElegible = false;
        Tier tier = getTierOfClientAccount(client);
        if (tier != Tier.BRONZE || client.getCreditScore() > 50) {
            isElegible = true;
            System.out.println("With a creditScore of " + client.getCreditScore() + "\n"
                    + "and a " + tier + " account," + "\n"
                    + client.getName() + " is elegible for a credit." + "\n"
                    + "Your tier grants you a discount of interest payments of -"
                    + tier.getInterestDisc() + "%");
        }
        return isElegible;
    }
}
