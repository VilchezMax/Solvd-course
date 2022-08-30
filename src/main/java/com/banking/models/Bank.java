package com.banking.models;


import com.banking.App;
import com.banking.exceptions.AmountException;
import com.banking.models.humans.BankWorker;
import com.banking.models.humans.Client;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Bank {
    //ATTRIBUTES
    private final String name;
    private String network;
    private int bankID;

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

    //METHODS

    public void setAccountIDClientMap(Map<Integer, Client> accountIDClientMap) {
        this.accountIDClientMap = accountIDClientMap;
    }

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

    public int newAccountId() {
        int max = 0;
        for (Account acc : this.accountList) {
            if (acc.getAccountID() > max) {
                max = acc.getAccountID();
            }
        }
        return max + 1;
    }

    public void increaseMinimumWages(Set<BankWorker> workers) {
        Optional<Double> minimumWage = workers.stream()
                .map(BankWorker::getWage)
                .min(Double::compare);

        workers.stream()
                .filter(worker -> Double.valueOf(worker.getWage()).equals(minimumWage))
                .map(worker -> {
                    worker.setWage((worker.getWage()) * 1.05);
                    return null;
                })
                .close();
    }

    //    public void increaseAllWages(Set<BankWorker> workers) {
//        Set<BankWorker> bankworkers = workers.stream()
//                .map(worker -> worker.setWage(10))
//                .collect(Collectors.toSet());
//    }
    public void increaseCreditScore(Map<Integer, Client> clientMap) {
//        Set<Map.Entry<Integer, Client>> clients = clientMap.entrySet();
        clientMap.entrySet().stream()
                .filter(accountID -> 50 < accountID.getValue().getCreditScore())
                .forEach(accountID -> {
                    accountID.getValue().setCreditScore(accountID.getValue().getCreditScore() + 10);
                });
    }
    public int findIndexByID(int accountID) {
        int index = -1;
        for (Account acc : this.getAccountList()) {
            if (acc.getAccountID() == accountID) {
                index = this.getAccountList().indexOf(acc);
            }
        }
        return index;
    }

    public void clientApp(Client client) {

        final Logger logger = LogManager.getLogger(Bank.class);
        Scanner input = new Scanner(System.in);

        int option = 1;
        double amount;

        while (option != 0) {
            logger.info("Hello " + client.getName() + ". What do you want to do? \n" + "1-CHECK BALANCE | 2-CREDIT | 3-DEPOSIT | 4-TRANSFER | other-EXIT");

            try {
                option = input.nextInt();
            } catch (IllegalArgumentException e) {
                logger.warn("You have to input a number", e);
            } catch (Exception e) {
                logger.warn(e);
            }

            switch (option) {
                case ClientMenu.CHECK_BALANCE.getOption(): //CHECK BALANCE
                    double balance = this.getAccountList().get(Account.findIndexByID(client.getAccount().getAccountID(),this.getAccountList()).getBalance();
                    logger.info("your balance is : " + balance); //TODO: getAccountByID
                    App.printLine();
                    break;
                case ClientMenu.CREDIT.getOption(): //CREDIT
                    if (!client.checkEligibilityForCredit()) {
                        logger.info("Your credit score is too low");
                    } else {
                        logger.info("The credit process is on track.");
                        Credit credit1 = new Credit(client.getAccount().getAccountID());
                        App.printLine();

                        //STEP 1: CHOOSE AMOUNT
                        logger.info("Max amount is " + Credit.calculateMaxAmount(account2.getAccountID())
                                + ". How much do you want to borrow?");
                        int tries = 0;
                        int creditAmount = 0;
                        while (tries < maxTries) {
                            try {
                                creditAmount = input.nextInt();
                                if (creditAmount > Credit.calculateMaxAmount(account2.getAccountID())) {
                                    throw new AmountException();
                                }
                                break;
                            } catch (InputMismatchException e) {
                                tries++;
                                logger.info((maxTries - tries) + " tries left.\n" + e);
                                logger.info("Wrong user input", e);
                                if (tries == maxTries) {
                                    logger.warn("User maxed out input tries(" + maxTries + ") ", e);
                                }
                            } catch (AmountException e) {
                                logger.warn(e);
                            }
                        }
                        App.printLine();

                        //STEP 2: CHOOSE N° INSTALLMENTS
                        logger.info("How many months do you want to pay it for?");
                        int months = input.nextInt();
                        App.printLine();
                        logger.info("Installments will be: " + Credit.calculateInstallment(
                                creditAmount, account2.getAccountID(), credit1.getMonthlyInterest(), months, credit1
                        ) + "/month");
                        App.printLine();
                        logger.info("Old balance=" + account2.getBalance());
                        double newBalance = account2.setBalance(account2.getBalance() + creditAmount);
                        logger.info("New Balance=" + newBalance);
                        App.printLine();
                    }
                    break;
                case ClientMenu.DEPOSIT.getOption(): //DEPOSIT
                    App.printLine();
                    logger.info("Deposit into your account");
                    Deposit deposit1 = new Deposit(account2.getAccountID());
                    logger.info("How much?");
                    amount = input.nextDouble();
                    logger.info("Old balance=" + account2.getBalance());
                    deposit1.setAmount(amount);
                    deposit1.deposit();
                    logger.info("New Balance=" + account2.getBalance());
                    App.printLine();
                    if (amount > 1000) {
                        logger.log(Level.forName("POLICE", 350), "Inform POLICE of $" + amount + " movement");
                    }
                    break;

                case ClientMenu.TRANSFER.getOption(): //TRANSFER
                    App.printLine();
                    logger.info("What is the account on the receiving end?");
                    int destinationAccount = input.nextInt();
                    Transfer transfer1 = new Transfer(account2.getAccountID(), destinationAccount);
                    logger.info("How much? Maximum is: " + transfer1.getMaxAmount());
                    amount = input.nextDouble();
                    transfer1.transfer(amount);
                    App.printLine();
                    logger.info("$" + amount + " sent to Account " + destinationAccount);
                    App.printLine();
                    logger.info("Account " + account2.getAccountID());
                    logger.info("New Balance = " + account2.getBalance());

                    if (amount > 1000) {
                        logger.log(Level.forName("POLICE", 350), "Inform POLICE of $" + amount + " movement");
                    }

                default: //EXIT
                    App.printLine();
                    logger.info("Thank you for trusting SolvdBank, where quality is assured");
                    App.printLine();
                    option = 0;
                    break;
            }
        }
    }
}
