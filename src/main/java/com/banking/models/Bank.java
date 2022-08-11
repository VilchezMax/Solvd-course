package com.banking.models;

import java.util.ArrayList;
import java.util.Queue;

public class Bank {
    //ATTRIBUTES
    private final String name;
    private String network;
    private static ArrayList<Account> accountList=new ArrayList<>();
    private static ArrayList<Operation> operationList=new ArrayList<>();

    //CONSTRUCTOR
    public Bank() {
        this.name="SolvBank";
        this.network="Solvdift";
    }

    //GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public static ArrayList<Account> getAccountList() {
        return accountList;
    }

    public static void addAccount(Account acc) {
        Bank.accountList.add(acc);
    }

    public static ArrayList<Operation> getOperationList() {
        return operationList;
    }

    public static void addOperation(Operation op) {
        Bank.operationList.add(op);
    }

    //METHODS

}
