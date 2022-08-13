package com.banking.models.humans;


import com.banking.exceptions.UnregisteredException;
import com.banking.interfaces.IResign;
import com.banking.models.Account;
import com.banking.models.Bank;
import com.banking.models.Tier;

public class Client extends Adult implements IResign {
    //ATTRIBUTES
    private final int clientID;
    private final Account account; //TODO: HAVE ACCOUNT OBJECT, NOT ONLY ID.
    private boolean eligibilityForCredit;
    private String mainBranchAddress;

    //CONSTRUCTORS
    public Client(int clientID, boolean eligibilityForCredit, String mainBranchAddress) {
        this.clientID = clientID;
        this.account = Account.findMaxID(Bank.getAccountList()) + 1;
        this.eligibilityForCredit = eligibilityForCredit;
        this.mainBranchAddress = mainBranchAddress;
    }

    public Client(String name, int age, int idNumber, String occupation, int creditScore, int clientID, Account account, boolean eligibilityForCredit, String mainBranchAddress) {
        super(name, age, idNumber, occupation, creditScore);
        this.clientID = clientID;
        this.account = account;
        this.eligibilityForCredit = eligibilityForCredit;
        this.mainBranchAddress = mainBranchAddress;
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
                .get(Account.findIndexByID(client.getAccount()))
                .getTier();

        return tier;
    }

    public boolean checkEligibilityForCredit() {
        boolean isElegible = false;
        Tier tier = getTierOfClientAccount(this);
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

        if () {
            Bank.getAccountList().remove(this);
        }
        if (Bank.getAccountIDClientMap().containsKey(Integer.valueOf(this.getAccount()))) {
            Bank.getAccountIDClientMap().remove(Integer.valueOf(this.getAccount()), this);
        }
    }
}
