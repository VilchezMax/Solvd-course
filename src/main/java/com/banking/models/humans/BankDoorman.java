package com.banking.models.humans;

import com.banking.App;
import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public final class BankDoorman extends BankWorker {
    final Logger logger = LogManager.getLogger(BankDoorman.class);

    //Attributes
    Queue<Person> bankQueue = new PriorityQueue<>(100, (Person o1, Person o2) -> {

        /* Priorities:
         * Client vs Guest -> Both clients? Compare Tiers -> Same tier? Compare credit score -> Same conditions? Compare age
         */

        if (o1 instanceof Client && o2 instanceof Client) {
            if (((Client) o1).getAccountTier().getPriority()
                    == ((Client) o2).getAccountTier().getPriority()) {
                if (o1.getCreditScore() == o2.getCreditScore()) {
                    return compareAge(o1, o2);
                } else if (o1.getCreditScore() > o2.getCreditScore()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (((Client) o1).getAccountTier().getPriority()
                    > ((Client) o2).getAccountTier().getPriority()) {
                return -1;
            } else {
                return 1;
            }
        } else if (o1 instanceof Client && o2 instanceof Guest) {
            return -1;
        } else if (o1 instanceof Guest && o2 instanceof Client) {
            return 1;
        } else {
            return compareAge(o1, o2);
        }
    });

    public BankDoorman(Bank bank) {
        super(bank);
    }

    public BankDoorman(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, double wage, Bank bank) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore, wage, bank);
    }

    //Constructor
    public Queue<Person> getBankQueue() {
        return bankQueue;
    }

    //Setter
    public void setBankQueue(Queue<Person> bankQueue) {
        this.bankQueue = bankQueue;
    }

    //Methods
    public Guest getGuestInfo(int idNumber) {
        Scanner clientInput = new Scanner(System.in);
        //    public Guest(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore) {
        logger.info("You are not a client, please provide your information");
        logger.info("Name:");
        String name = clientInput.nextLine();
        App.printLine();

        logger.info("Age:");
        int age = clientInput.nextInt();
        App.printLine();

        logger.info("Occupation:");
        OccupationField[] occs = OccupationField.values();
        for (int i = 0; i < occs.length; i++) {
            logger.info((i + 1) + " - " + occs[i]);
        }
        OccupationField occupation = occs[clientInput.nextInt() - 1];
        App.printLine();

        logger.info("Seniority:");
        Seniority seniority = null;
        if (occupation != OccupationField.UNEMPLOYED) {
            Seniority[] srty = Seniority.values();
            for (int i = 0; i < srty.length; i++) {
                logger.info((i + 1) + " - " + srty[i]);
            }
            seniority = srty[clientInput.nextInt() - 1];
        }
        App.printLine();

        logger.info("CreditScore:");
        int creditScore = clientInput.nextInt();

        Guest guest = new Guest(name, age, idNumber, occupation, seniority, creditScore);

        this.bankQueue.add(guest);
        return guest;
    }

    public int compareAge(Person p1, Person p2) {
        if (p1.getAge() == p2.getAge()) {
            return 0;
        } else if (p1.getAge() > p2.getAge()) {
            return -1;
        }
        return 1;
    }
}
