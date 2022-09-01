package com.banking.models;


import com.banking.App;
import com.banking.exceptions.AmountException;
import com.banking.models.humans.BankWorker;
import com.banking.models.humans.Client;
import com.banking.models.humans.Guest;
import com.banking.models.humans.Person;
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
    private static Set<Integer> allAccountsID = new HashSet<>();    //Static because it's shared through all banks to not repeat accountID for transfers among diff banks.

    static {
        final Logger logger = LogManager.getLogger(App.class);
    }

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
    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

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

    public static Set<Integer> getAllAccountsID() {
        return allAccountsID;
    }

    public static void setAllAccountsID(Set<Integer> allAccountsID) {
        Bank.allAccountsID = allAccountsID;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    //METHODS
    public void setBankWorkerSet(Set<BankWorker> bankWorkerSet) {
        this.bankWorkerSet = bankWorkerSet;
    }

    public static int generateAccountID() {
        final Logger logger = LogManager.getLogger(Bank.class);
        int maxId = 0;

        try {
            maxId = Bank.allAccountsID.stream()
                    .max(Comparator.naturalOrder())
                    .get();
            Bank.allAccountsID.add(maxId);
            return maxId + 1;
        } catch (NoSuchElementException e) {
            logger.warn("No se pudo encontrar el id maximo de las cuentas" + e);
        }
        return maxId;
    }

    public Map<Integer, Client> getAccountIDClientMap() {
        return accountIDClientMap;
    }

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

    public void increaseMinimumWages() {
        Double minimumWage = this.bankWorkerSet.stream()
                .map(BankWorker::getWage)
                .min(Double::compare)
                .get();

        this.bankWorkerSet.stream()
                .filter(worker -> minimumWage.compareTo(worker.getWage()) == 0)
                .forEach(worker -> worker.setWage((worker.getWage()) * 1.05));
    }

    public void increaseAllWages() {
        this.bankWorkerSet.stream()
                .forEach(worker -> worker.setWage(10));
    }

    public void increaseWagesLargerThan(double wage) {
        this.bankWorkerSet.stream()
                .filter(worker -> worker.getWage() < wage)
                .forEach(worker -> worker.setWage(10));
    }

    public void increaseCreditScore(Map<Integer, Client> clientMap) {
        clientMap.entrySet().stream()
                .filter(accountID -> 50 < accountID.getValue().getCreditScore())
                .forEach(accountID -> {
                    accountID.getValue().setCreditScore(accountID.getValue().getCreditScore() + 10);
                });
    }

//    public int findIndexByID(int accountID) {
//        int index = -1;
//        for (Account acc : this.getAccountList()) {
//            if (acc.getAccountID() == accountID) {
//                index = this.getAccountList().indexOf(acc);
//            }
//        }
//        return index;
//    }

    public boolean isClientOrGuest(Bank bank, int idNumber) {
        return bank.getAccountIDClientMap()
                .values()
                .stream()
                .anyMatch(client -> client.getIdNumber() == idNumber);
    }


    public void clientApp(Client client) {

        final Logger logger = LogManager.getLogger(Bank.class);
        Scanner input = new Scanner(System.in);

        Account account = client.getAccount();
        int accountId = account.getAccountID();
        double balance;

        int option = 1;
        double amount;

        while (option != 0) {
            logger.info("Hello " + client.getName() + ". What do you want to do? \n" + "1-CHECK BALANCE | 2-CREDIT | 3-DEPOSIT | 4-TRANSFER | other-EXIT");
            balance = account.getBalance();
            try {
                option = input.nextInt();
            } catch (IllegalArgumentException e) {
                logger.warn("You have to input a number", e);
            } catch (Exception e) {
                logger.warn(e);
            }

            switch (option) {
                case 1: //CHECK BALANCE
                    logger.info("your balance is : " + balance);
                    App.printLine();
                    break;

                case 2: //CREDIT
                    if (!client.checkEligibilityForCredit()) {
                        logger.info("Your credit score is too low");
                    } else {
                        logger.info("The credit process is on track.");
                        Credit credit = new Credit(this, client.getAccount().getAccountID());
                        App.printLine();

                        //STEP 1: CHOOSE AMOUNT
                        logger.info("Max amount is " + Credit.calculateMaxAmount(this, account.getAccountID())
                                + ". How much do you want to borrow?");
                        int tries = 0;
                        int creditAmount = 0;
                        while (tries < App.maxTries) {
                            try {
                                creditAmount = input.nextInt();
                                if (creditAmount > Credit.calculateMaxAmount(this, account.getAccountID())) {
                                    throw new AmountException();
                                }
                                break;
                            } catch (InputMismatchException e) {
                                tries++;
                                logger.info((App.maxTries - tries) + " tries left.\n" + e);
                                logger.info("Wrong user input", e);
                                if (tries == App.maxTries) {
                                    logger.warn("User maxed out input tries(" + App.maxTries + ") ", e);
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

                        logger.info("Installments will be: " + Credit.calculateInstallment(this,
                                creditAmount, account.getAccountID(), credit.getMonthlyInterest(this), months, credit
                        ) + "/month");
                        App.printLine();

                        logger.info("Old balance=" + account.getBalance());
                        account.setBalance(account.getBalance() + creditAmount);
                        double newBalance = account.getBalance();

                        logger.info("New Balance=" + newBalance);
                        App.printLine();
                    }
                    break;
                case 3: //DEPOSIT
                    App.printLine();
                    logger.info("Deposit into your account");
                    Deposit deposit = new Deposit(this, account.getAccountID());
                    logger.info("How much?");
                    amount = input.nextDouble();
                    logger.info("Old balance=" + account.getBalance());
                    deposit.setAmount(amount);
                    deposit.deposit(this);
                    logger.info("New Balance=" + account.getBalance());
                    App.printLine();

                    if (amount > 1000) {
                        logger.log(Level.forName("POLICE", 350), "Inform POLICE of $" + amount + " movement");
                    }
                    break;

                case 4: //TRANSFER
                    App.printLine();
                    logger.info("What is the account on the receiving end?");
                    int destinationAccount = input.nextInt();
                    Transfer transfer1 = new Transfer(this, account.getAccountID(), destinationAccount);
                    logger.info("How much? Maximum is: " + transfer1.getMaxAmount());
                    amount = input.nextDouble();
                    transfer1.transfer(this, amount);
                    App.printLine();
                    logger.info("$" + amount + " sent to Account " + destinationAccount);
                    App.printLine();
                    logger.info("Account " + account.getAccountID());
                    logger.info("New Balance = " + account.getBalance());

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

    public void signingUp(Guest guest) {
        Client newClient = new Client(guest.getName(), guest.getAge(), guest.getIdNumber(), guest.getOccupation(), guest.getJobSeniority(), guest.getCreditScore(), new Account());
        this.accountList.add(newClient.getAccount());
        this.accountIDClientMap.put(newClient.getAccount().getAccountID(), newClient);
    }

    public void signingUp(Person person) {
        Client newClient = new Client(person.getName(), person.getAge(), person.getIdNumber(), person.getOccupation(), person.getJobSeniority(), person.getCreditScore(), new Account());
        this.accountList.add(newClient.getAccount());
        this.accountIDClientMap.put(newClient.getAccount().getAccountID(), newClient);
    }
}
