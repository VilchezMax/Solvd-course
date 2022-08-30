package com.banking.models.humans;

import com.banking.models.*;

public class DataBaseAdministrator extends BankWorker {
    //Attributes

    //Constructors

    //Setters & Getters

    //Methods
    public void dbMigration(Bank bank) {

        //Accounts
        bank.getAccountList().add(new Account(1));
        bank.getAccountList().add(new Account(2, Tier.SOLVD, 100000));
        bank.getAccountList().add(new Account(3, Tier.GOLDEN, 15000));
        bank.getAccountList().add(new Account(4, Tier.SILVER, 10000));
        bank.getAccountList().add(new Account(5, Tier.BRONZE, 5000));
        bank.getAccountList().add(new Account(754963, Tier.BRONZE, 0.99));
        bank.getAccountList().add(new Account(7893148, Tier.SOLVD, 12345.89));

        //Guests
        Guest guest1 = new Guest("Dzmitry Prymudrau", 28, 10, OccupationField.EDUCATION, Seniority.PRINCIPAL, 100);
        Guest guest2 = new Guest("Juan Paraducha", 25, 11, OccupationField.IT, Seniority.SENIOR, 50);
        Guest guest3 = new Guest("Mariana Cañas", 28, 12, OccupationField.BUSINESS, Seniority.SEMI_SENIOR, 60);
        Guest guest4 = new Guest("Lautaro garibaldi", 29, 13, OccupationField.COMMUNICATIONS, Seniority.JUNIOR, 60);
        Guest guest5 = new Guest("Nahuel Sanabria", 30, 14, OccupationField.SCIENCE, Seniority.TRAINEE, 60);


        //Clients
        Client client1 = new Client("Max Vilchez", 27, 38789789, OccupationField.IT, Seniority.SENIOR, 49, bank.getAccountList().get(5), bank);
        Client client2 = new Client("Sergei Zagriychuk", 30, 12, OccupationField.IT, Seniority.PRINCIPAL, 400, bank.getAccountList().get(6), bank);
        Client client3 = new Client("Viktoria Legakis", 22, 40404040, OccupationField.ART_CULTURE, Seniority.SEMI_SENIOR, 500, bank.getAccountList().get(3), bank);
        Client client4 = new Client("Celeste Gonzalez", 24, 41414141, OccupationField.MANUFACTURE, Seniority.JUNIOR, 300, bank.getAccountList().get(2), bank);
        Client client5 = new Client("Julian Schirmer", 23, 40404141, OccupationField.HEALTH, Seniority.TRAINEE, 200, bank.getAccountList().get(1), bank);

        //Operations


        //Transfers


        //Deposits

    }

}
