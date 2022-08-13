package com.banking.models;


import com.banking.models.humans.BankWorker;
import com.banking.models.humans.Client;

import java.util.*;

public class Bank {
    //ATTRIBUTES
    private final String name;
    private String network;

    private ArrayList<Account> accountList = new ArrayList<>();
    private ArrayList<Operation> operationList = new ArrayList<>();
    private Set<BankWorker> bankWorkerSet = new HashSet<>();
    private Map<Integer, Client> accountIDClientMap = new HashMap<>();

    //CONSTRUCTOR
    public Bank() {
        this.name = "SolvdBank";
        this.network = "Banelco";
    }

    public Bank(String name, String network) {
        this.name = name;
        this.network = network;
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

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void addAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public ArrayList<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(ArrayList<Operation> operationList) {
        this.operationList = operationList;
    }

    public Set<BankWorker> getBankWorkerSet() {
        return bankWorkerSet;
    }

    public void setBankWorkerSet(Set<BankWorker> bankWorkerSet) {
        this.bankWorkerSet = bankWorkerSet;
    }

    public Map<Integer, Client> getAccountIDClientMap() {
        return accountIDClientMap;
    }

    public void setAccountIDClientMap(Map<Integer, Client> accountIDClientMap) {
        this.accountIDClientMap = accountIDClientMap;
    }

    //METHODS
    public int findAccountByID(int accountID) {
        int index = -1;
        for (Account acc : this.accountList) {
            if (acc.getAccountID() == accountID) {
                index = this.accountList.indexOf(acc);
            }
        }
        return index;
    }

    public void clearAccount(Account account) throws IllegalArgumentException {
        if (this.accountList.contains(account)) {
            this.accountList.remove(account);
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
        if (this.accountIDClientMap.containsValue(account)) {
            this.accountIDClientMap.remove(Integer.valueOf(account.getAccountID()));
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public void clearAccount(Client client) throws IllegalArgumentException {

        if (this.accountList.contains(client.getAccount())) {
            this.accountList.remove(client.getAccount());
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (this.accountIDClientMap.containsValue(client)) {
            this.accountIDClientMap.remove(Integer.valueOf(client.getAccount().getAccountID()));
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
    }


}
