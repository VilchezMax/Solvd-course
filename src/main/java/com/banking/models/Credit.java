package com.banking.models;

public class Credit extends Operation {
    //ATTRIBUTES
    int borrowingAccountID;
    double maxAmount;
    double installments;
    double monthlyInterest;

    //CONSTRUCTOR

    public Credit(Bank bank, int borrowingAccountID) {
        super(bank);
        this.borrowingAccountID = borrowingAccountID;
        this.maxAmount = calculateMaxAmount(bank, borrowingAccountID);
    }


    //SETTERS & GETTERS

    public int getBorrowingAccountID() {
        return borrowingAccountID;
    }

    public void setBorrowingAccountID(int borrowingAccountID) {
        this.borrowingAccountID = borrowingAccountID;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getInstallments() {
        return installments;
    }

    public void setInstallments(double installments) {
        this.installments = installments;
    }

    public double getMonthlyInterest(Bank bank) {
        Account acc = Account.findAccountByID(bank, this.borrowingAccountID);
        Tier tier = acc.getTier();
        monthlyInterest -= tier.getInterestDisc();
        return monthlyInterest;
    }

    public void setMonthlyInterest(double monthlyInterest) {
        if (monthlyInterest > 5) {
            this.monthlyInterest = monthlyInterest;
        } else {
            throw new IllegalArgumentException("interest has to be higher that 5%");
        }
    }

    //METHODS
    public static double calculateMaxAmount(Bank bank, int borrowingAccountID) {
        double maxAmount = 0;
        Account acc = Account.findAccountByID(bank, borrowingAccountID);
        Tier tier = acc.getTier();
        maxAmount = acc.getBalance() * tier.getMaxAmountMultiplier();
        return maxAmount;
    }

    public static double calculateInstallment(Bank bank, int amount, int borrowingAccountID, double monthlyInterest, int months, Credit credit) {
        double insta = (amount / months) + ((amount / months) * credit.getMonthlyInterest(bank));
        return insta;
    }

}
