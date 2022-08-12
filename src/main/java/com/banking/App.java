package com.banking;

import com.banking.exceptions.AmountException;
import com.banking.models.*;
import com.banking.models.humans.Client;
import com.banking.models.humans.Guest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner keyboardInput = new Scanner(System.in);

    static int maxTries;

    static {
        maxTries = 3;
    }

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Entering application.");
        printLine();

        Bank.addAccount(new Account(147859));
        Bank.addAccount(new Account(143945));

        //Guest tries to take a credit.
        Guest guest1 = new Guest("Dzmitry", 28, 10, "Automation Engineer", 100);
        if (!guest1.isElegibileForCredit()) {
            logger.warn("You are a guest, you need an account to ask for a credit");
        }
        printLine();

        //Client with low credit
        Account account1 = new Account(754963, Tier.BRONZE, 0.99);
        Bank.addAccount(account1);
        Client client1 = new Client("Max", 27, 38789789, "QA TA Engineer",
                49, 11, account1.getAccountID(), false, "Solvd Arg HQ");
        if (!client1.checkEligibilityForCredit()) {
            System.out.println(client1.getName() + ", your credit score of " + client1.getCreditScore() + " is too low.");
        }
        printLine();

        //Adding client that tests methods
        Account account2 = new Account(7893148, Tier.SOLVD, 12345.89);
        Bank.addAccount(account2);
        Client client2 = new Client("Sergei", 30, 12, "Team lead QA",
                400, 80, account2.getAccountID(), true, "Solvd Main HQ");
        account2.setClient(client2);

        //OPTIONS MENU
        int option = 1;
        double amount;
        while (option != 0) {
            System.out.println("Hello " + account2.getClient().getName() + ". What do you want to do? \n" +
                    "1-CHECK BALANCE | 2-CREDIT | 3-DEPOSIT | 4-TRANSFER | other-EXIT");
            try {
                option = keyboardInput.nextInt();
            } catch (IllegalArgumentException e) {
                logger.warn("You have to input a number", e);
            } catch (Exception e) {
                logger.warn(e);
            }

            switch (option) {
                case 1: //CHECK BALANCE
                    double balance = Bank.getAccountList().get(Account.findIndexByID(client2.getAccountID())).getBalance();
                    System.out.println("your balance is : " + balance); //TODO: getAccountByID
                    printLine();
                    break;
                case 2: //CREDIT
                    if (!client2.checkEligibilityForCredit()) {
                        System.out.println("Your credit score is too low");
                    } else {
                        System.out.println("The credit process is on track.");
                        Credit credit1 = new Credit(account2.getAccountID());
                        printLine();

                        //STEP 1: CHOOSE AMOUNT
                        System.out.println("Max amount is " + Credit.calculateMaxAmount(account2.getAccountID())
                                + ". How much do you want to borrow?");
                        int tries = 0;
                        int creditAmount = 0;
                        while (tries < maxTries) {
                            try {
                                creditAmount = keyboardInput.nextInt();
                                if (creditAmount > Credit.calculateMaxAmount(account2.getAccountID())) {
                                    throw new AmountException();
                                }
                                break;
                            } catch (InputMismatchException e) {
                                tries++;
                                System.out.println((maxTries - tries) + " tries left.\n" + e);
                                logger.info("Wrong user input", e);
                                if (tries == maxTries) {
                                    logger.warn("User maxed out input tries(" + maxTries + ") ", e);
                                }
                            } catch (AmountException e) {
                                logger.warn(e);
                            }
                        }
                        printLine();

                        //STEP 2: CHOOSE N° INSTALLMENTS
                        System.out.println("How many months do you want to pay it for?");
                        int months = keyboardInput.nextInt();
                        printLine();
                        System.out.println("Installments will be: " + Credit.calculateInstallment(
                                creditAmount, account2.getAccountID(), credit1.getMonthlyInterest(), months, credit1
                        ) + "/month");
                        printLine();
                        System.out.println("Old balance=" + account2.getBalance());
                        double newBalance = account2.setBalance(account2.getBalance() + creditAmount);
                        System.out.println("New Balance=" + newBalance);
                        printLine();
                    }
                    break;
                case 3: //DEPOSIT
                    printLine();
                    System.out.println("Deposit into your account");
                    Deposit deposit1 = new Deposit(account2.getAccountID());
                    System.out.println("How much?");
                    amount = keyboardInput.nextDouble();
                    System.out.println("Old balance=" + account2.getBalance());
                    deposit1.setAmount(amount);
                    deposit1.deposit();
                    System.out.println("New Balance=" + account2.getBalance());
                    printLine();
                    if (amount > 1000) {
                        logger.log(Level.forName("POLICE", 350), "Inform POLICE of $" + amount + " movement");
                    }
                    break;

                case 4: //TRANSFER
                    printLine();
                    System.out.println("What is the account on the receiving end?");
                    int destinationAccount = keyboardInput.nextInt();
                    Transfer transfer1 = new Transfer(account2.getAccountID(), destinationAccount);
                    System.out.println("How much? Maximum is: " + transfer1.getMaxAmount());
                    amount = keyboardInput.nextDouble();
                    transfer1.transfer(amount);
                    printLine();
                    System.out.println("$" + amount + " sent to Account " + destinationAccount);
                    printLine();
                    System.out.println("Account " + account2.getAccountID());
                    System.out.println("New Balance = " + account2.getBalance());

                    if (amount > 1000) {
                        logger.log(Level.forName("POLICE", 350), "Inform POLICE of $" + amount + " movement");
                    }

                default: //EXIT
                    printLine();
                    System.out.println("Thank you for trusting SolvdBank, where quality is assured");
                    printLine();
                    option = 0;
                    break;
            }
        }
        logger.info("Exiting application.");
        System.exit(-1);
    }

    public static void printLine() {
        System.out.println("-----------------------------------------------------");
    }

}

