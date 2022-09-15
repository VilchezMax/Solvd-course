package com.banking.models;


import com.banking.App;
import com.banking.exceptions.AmountException;
import com.banking.exceptions.UnregisteredException;
import com.banking.models.humans.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Bank {
    static final Logger logger = LogManager.getLogger(Bank.class);
    //ATTRIBUTES
    private final String name;
    private int bankID;
    private ArrayList<Account> accountList = new ArrayList<>();
    private ArrayList<Operation> operationList = new ArrayList<>();
    private Set<BankWorker> bankWorkerSet = new HashSet<>();
    private Map<Integer, Client> accountIDClientMap = new HashMap<>();

    //Static because it's shared through all banks to not repeat accountID for transfers among diff banks.
    private static Set<Integer> allAccountsID = new HashSet<>();

    //CONSTRUCTOR
    public Bank() {
        this.name = "SolvdBank";
    }

    public Bank(String name) {
        this.name = name;
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
        int maxId = 0;
        if (!Bank.allAccountsID.isEmpty()) {
            try {
                maxId = Bank.allAccountsID
                        .stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt();

            } catch (NoSuchElementException e) {
                logger.warn("No se pudo encontrar el id maximo de las cuentas. " + e);
            }
        }
        Bank.allAccountsID.add(maxId + 1);
        return maxId + 1;
    }

    public int generateOperationID() {
        int maxId = 0;
        if (!this.getOperationList().isEmpty()) {
            try {
                maxId = this.getOperationList()
                        .stream()
                        .mapToInt(Operation::getOpID)
                        .max()
                        .getAsInt();

            } catch (NoSuchElementException e) {
                logger.warn("No se pudo encontrar el id maximo de las cuentas. " + e);
            }
        }
        Bank.allAccountsID.add(maxId + 1);
        return maxId + 1;
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

    //Method exists because "SET" doesn't have native GET method weirdly enough.
    @SuppressWarnings("unchecked")
    public <T extends BankWorker> T getBankWorker(Class<T> workerClass) {
        return (T) this.bankWorkerSet
                .stream()
                .filter(worker -> worker.getClass().equals(workerClass))
                .findFirst()
                .orElse(null);

    }

    public void clearAccount(Account account) throws IllegalArgumentException {
        Integer id = account.getAccountID();

        if (this.accountList.contains(account)) {
            this.accountList.remove(account);
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (this.accountIDClientMap.containsKey(id)) {
            this.accountIDClientMap.remove(id);
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public void clearAccount(Client client) throws IllegalArgumentException {
        Account account = client.getAccount();

        if (this.accountList.contains(account)) {
            this.accountList.remove(account);
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }

        if (this.accountIDClientMap.containsValue(client)) {
            this.accountIDClientMap.remove(account.getAccountID());
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public void increaseCreditScoreIfMinus50(Map<Integer, Client> clientMap) {
        clientMap.entrySet().stream()
                .filter(accountID -> 50 < accountID.getValue().getCreditScore())
                .forEach(accountID -> {
                    accountID.getValue().setCreditScore(accountID.getValue().getCreditScore() + 10);
                });
    }

    public boolean isClient(int idNumber) {
        return this.accountIDClientMap
                .values()
                .stream()
                .anyMatch(client -> client.getIdNumber() == idNumber);
    }

    //MAIN FLOW OF THE APP, CALLED FROM MAIN METHOD.
    public void clientApp(int idNumber) throws UnregisteredException, AmountException {
        Scanner input = new Scanner(System.in);

        Client client = this.getClientByID(idNumber);
        Account account = client.getAccount();

        int accountId = account.getAccountID();
        double balance;

        int option = 1;
        double amount;

        while (option != 0) {
            logger.info("Hello " + client.getName() + ". What do you want to do? \n"
                    + "1-CHECK BALANCE | 2-CREDIT | 3-DEPOSIT | 4-TRANSFER | 5-CANCEL ACCOUNT | other-EXIT");
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
                    App.printLine();
                    logger.info("Your balance is : " + balance);
                    App.printLine();
                    break;

                case 2: //CREDIT
                    App.printLine();

                    if (!client.checkEligibilityForCredit()) {
                        logger.info("Your credit score is too low");
                        App.printLine();
                    } else {
                        logger.info("With a creditScore of " + client.getCreditScore() + " and a "
                                + client.getAccountTier() + " account," + "\n"
                                + client.getName() + " is elegible for a credit." + "\n"
                                + "Your tier grants you a discount on interest payments of -"
                                + client.getAccountTier().getInterestDisc() + "%");
                        logger.info("The credit process is on track.");
                        Credit credit = new Credit(this, client.getAccount().getAccountID());
                        App.printLine();

                        //STEP 1: CHOOSE AMOUNT
                        logger.info("Max amount is " + Credit.calculateMaxAmount(this, account.getAccountID())
                                + ". How much do you want to borrow?");
                        int tries = 0;
                        int creditAmount = 0;
                        while (tries++ < App.maxTries) {
                            try {
                                creditAmount = input.nextInt();
                                if (creditAmount > Credit.calculateMaxAmount(this, account.getAccountID())) {
                                    throw new AmountException();
                                }
                                break;
                            } catch (InputMismatchException e) {
                                logger.info((App.maxTries - tries) + " tries left.\n" + e);
                                logger.info("Wrong user input", e);
                                if (tries == App.maxTries) {
                                    logger.warn("User maxed out input tries(" + App.maxTries + ") ", e);
                                }
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
                    break;
                case 5: //CANCEL ACCOUNT
                    try {
                        client.resign();
                        logger.info("You are welcome to this bank whenever you want to come back. " +
                                "All your accounts were canceled successfully");
                    } catch (UnregisteredException e) {
                        logger.warn(e);
                    }
                    App.printLine();
                    input.close();
                    break;
                default: //EXIT
                    input.close();
                    App.printLine();
                    logger.info("Thank you for trusting SolvdBank, where quality is assured");
                    App.printLine();
                    option = 0;
                    break;
            }
        }
    }

    public void guestApp(int idNumber) {
        Scanner input = new Scanner(System.in);

        try {
            BankDoorman doorman = this.getBankWorker(BankDoorman.class);
            Guest guest = doorman.getGuestInfo(idNumber);
            logger.info("Would you want to join our bank and get excellent benefits?\n"
                    + "We offer a bonus increase in credit score for new signups");
            logger.info("1-YES | other-NO");
            int option = input.nextInt();
            if (option == 1) {
                Client newClient = this.signUp(guest);
                logger.info("Your credit score has been increased from " + newClient.getCreditScore() + " to "
                        + this.getBankWorker(CEO.class).signUpCreditScoreBonus(newClient.getClientID()));
                logger.info("You are being redirected to client homepage");
                this.clientApp(newClient.getIdNumber());
            }
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    public Client getClientByID(int idNumber) {
        return this.accountIDClientMap.values()
                .stream()
                .filter(client -> client.getIdNumber() == idNumber)
                .findFirst()
                .orElse(null);
    }

    public Client signUp(Guest guest) {
        Client newClient = new Client(guest.getName(), guest.getAge(), guest.getIdNumber(), guest.getOccupation(), guest.getJobSeniority(), guest.getCreditScore(), new Account());
        this.accountList.add(newClient.getAccount());
        this.accountIDClientMap.put(newClient.getAccount().getAccountID(), newClient);
        return newClient;
    }

    public <T extends BankWorker> void fire(T worker) throws UnregisteredException {
        if (this.bankWorkerSet.contains(worker)) {
            this.bankWorkerSet.remove(worker);
        } else {
            throw new UnregisteredException();
        }
    }

    public <T extends BankWorker> void employ(T worker) {
        this.bankWorkerSet.add(worker);
    }


}
