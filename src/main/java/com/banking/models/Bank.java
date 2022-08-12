package com.banking.models;


import com.banking.models.humans.BankWorker;
import com.banking.models.humans.Client;

import java.util.*;

public class Bank {
    //ATTRIBUTES
    private final String name;
    private String network;
    private static ArrayList<Account> accountList=new ArrayList<>();
    private static ArrayList<Operation> operationList=new ArrayList<>();
    private static Set<BankWorker> bankWorkerSet =new HashSet<>();
    private static Map<Integer, Client> AccountIDClientMap = new HashMap<>();

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

    public static Set<BankWorker> getBankWorkerSet() {
        return bankWorkerSet;
    }

    public static void setBankWorkerSet(Set<BankWorker> bankWorkerSet) {
        Bank.bankWorkerSet = bankWorkerSet;
    }

    public static Map<Integer, Client> getAccountIDClientMap() {
        return AccountIDClientMap;
    }

    public static void setAccountIDClientMap(Map<Integer, Client> accountIDClientMap) {
        AccountIDClientMap = accountIDClientMap;
    }

    //METHODS

}