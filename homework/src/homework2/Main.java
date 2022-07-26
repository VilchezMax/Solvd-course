package homework2;

import homework2.models.*;

import java.util.Scanner;

import static homework2.models.Tier.BRONZE;
import static homework2.models.Tier.SOLVD;

/*
 * TODO LIST:
 *  IMPORTANT: REFACTOR HIERARCHIES AS SERGEI SAID ON CLASS 3 VIDEO 26/07.
 *          Guest att/meths are incomplete, should be elegible for credit and validated
 *          why minor exist if it cant extend client/guest? doesnt do anything. Add a Tier for minor accounts.
 *          better to implement class Person, extend to Workers/clients
 *          Because if class is guest, cant turn into client, its better being an attribute "account null or xxxx"
 *          if account null => guest
 *          if guest => no credit
 *  IMPORTANT: REFACTOR STATIC METHODS TO INSTANCE METHODS WHEN APPROPIATE.
 *      i.e: Client.checkEligibilityForCredit(client); -> client.checkEliginilityForCredit();
 *      Static methods use them to search parameter on lists, better.
 *  IMPORTANT: min 1:06:00 - Use interNetwork attribute for valdiations.
 *  fix Sergei TIER in Account2, it prints BRONZE, it should print SOLVD.
 *  fix amount offered for credit. it is way too large. search for mistake, so many 0's it prints "E".
 *  move Credit to Operation Menu.
 */

public class Main {
    static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        printLine();
        //MOCK STRUCTURES TO FILL ARRAYLISTS
        Bank.addAccount(new Account(147859));
        Bank.addAccount(new Account(143945));

        Guest guest1 = new Guest("Dzmitry", 28, 10, "Automation Engineer", 100);
        if (guest1.isElegibilityForCredit() == false) {
            System.out.println(guest1.getName() + ", you are a guest, you need an account to ask for a credit.");
        }
        printLine();
        Account account1 = new Account(754963, BRONZE, 0.99);
        Bank.addAccount(account1);
        Client client1 = new Client("Max", 27, 38789789, "QA TA Engineer",
                49, 11, account1.getAccountID(), false, "Solvd Arg HQ");
        if (!Client.checkEligibilityForCredit(client1)) {
            System.out.println(client1.getName() + ", your credit score of " + client1.getCreditScore() + " is too low.");
        }
        printLine();
        Account account2 = new Account(7893148, SOLVD, 12345.89);
        Bank.addAccount(account2);
        Client client2 = new Client("Sergei", 30, 12, "Team lead QA",
                400, 80, account2.getAccountID(), true, "Solvd Main HQ");
        if (!Client.checkEligibilityForCredit(client2)) {
            System.out.println("Your credit score is too low");
        } else {
            System.out.println("You will be granted the credit.");
            Credit credit1 = new Credit(account2.getAccountID());
            printLine();
            System.out.println("Max Amount is " + Credit.calculateMaxAmount(account2.getAccountID())
                    + "How much do you wanna borrow?");
            int amount = keyboardInput.nextInt();
            printLine();
            System.out.println("How many months do you want to pay it for?");
            int months = keyboardInput.nextInt();
            printLine();
            System.out.println("Installments will be: " + Credit.calculateInstallment(
                    amount, account2.getAccountID(), credit1.getMonthlyInterest(), months, credit1
            ) + "/month");
            printLine();
            System.out.println("Old balance=" + account2.getBalance());
            double newBalance = account2.setBalance(account2.getBalance() + amount);
            System.out.println("New Balance=" + newBalance);
            printLine();
        }

        int option = 1;
        double amount;
        while (option != 0) {
            System.out.println("What else do you want to do now? 1-Deposit | 2-Transfer | Other-Exit");
            option = keyboardInput.nextInt();
            switch (option) {
                case 1: //DEPOSIT
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
                    break;

                case 2: //TRANSFER
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

                default: //EXIT
                    printLine();
                    System.out.println("Thank you for trusting SolvdBank, where quality is assured");
                    printLine();
                    option = 0;
                    break;
            }
        }
        System.exit(-1);
    }

    public static void printLine() {
        System.out.println("-----------------------------------------------------");
    }
}
