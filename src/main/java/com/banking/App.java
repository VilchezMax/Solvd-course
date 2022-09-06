package com.banking;

import com.banking.exceptions.UnregisteredException;
import com.banking.models.Bank;
import com.banking.models.Message;
import com.banking.models.humans.DataBaseAdministrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class App {

    public static int maxTries = 3;
    static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(App.class);
        logger.info("Entering application.");
        printLine();

        Bank bank = new Bank();

        //Adds all initial information to bank collections with DBA singleton class;
        DataBaseAdministrator dba = DataBaseAdministrator.getDBA(bank);
        dba.dbMigration(bank);

        logger.info(Message.GREETING.getMessage());
        logger.info("Please Insert your ID Number to operate:");
        int idNumber = keyboardInput.nextInt();
        if (bank.isClient(idNumber)) {
            try {
                bank.clientApp(idNumber);
            } catch (UnregisteredException e) {
                logger.warn(e);
            }
        } else {
            try {
                bank.guestApp(idNumber);
            } catch (Exception e) {
                logger.warn(e);
            }
        }
        logger.info("Exiting application.");
        System.exit(-1);
    }

    public static void printLine() {
        System.out.println("~----~-----------~----------~----------~------------~----~");
    }

}

