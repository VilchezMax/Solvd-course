package homework2.models;

import homework22.models.Tier;
/*
import java.util.ArrayList;

public class Account {
    private int accountID;
    private Tier tier;
    private double balance;

    public Account(int accountID, Tier tier, double balance) {
        this.accountID = accountID;
        this.tier = Tier.bronze;
        this.balance = balance;
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

    //METHODS

    @Override
    public boolean equals(Object obj) {
        boolean isEqual=false;
        if(obj instanceof Account ){
            isEqual=((Account) obj).getAccountID()==(this.getAccountID());;
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.getAccountID();
    }

    //Checks if id doesn't already exist and creates a new one.
    public static int generateAccountID(ArrayList<Account> accountList){
        boolean newID=false;
        int id;
        do {
            id =(int) Math.random()*1000;
            for (Account a:accountList){
                if(a.getAccountID()==id){
                    break;
                }
                newID=true;
            }
        } while (!newID);
        return id;
    }
    public static Account findByID(int accountID,ArrayList<Account> accountList) {

        for (Account a : accountList) {
            if (a.getAccountID()==accountID){
                return a;
            }

        }
        return null;
    }

}
*/