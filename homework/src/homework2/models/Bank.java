package homework2.models;
/*
import homework22.models.Tier;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String name;
    private String network;
    private ArrayList<Account> accounts;
    private ArrayList<Procedure> procedures;

    public Bank(String name, String network){
        this.name = name;
        this.network = network;
        this.accounts=new ArrayList<>();
        this.procedures=new ArrayList<>();
    }


    //METHODS
    public static int generateAccountID(ArrayList<Account> accountList){
        boolean newID=false;
        int id = 0;
        while (!newID){
            id =(int) Math.random()*1000;
            for (Account a:accountList){
                if(a.getAccountID()==id){
                    newID=false;
                    break;
                }
                newID=true;
            }
        }
        return id;
    }

    public static boolean checkEligibilityForCredit(Client client){
        boolean isElegible=false;
        if (client.getTier()!= Tier.bronze || client.getCreditScore()>50){
            isElegible=true;
        }
        return isElegible;
    }

}
*/