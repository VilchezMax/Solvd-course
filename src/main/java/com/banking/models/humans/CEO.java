package com.banking.models.humans;

import com.banking.models.Bank;
import com.banking.models.OccupationField;
import com.banking.models.Seniority;

public class CEO extends BankWorker {

    public CEO(Bank bank) {
        super(bank);
    }

    public CEO(String name, int age, int idNumber, OccupationField occupation, Seniority jobSeniority, int creditScore, double wage, Bank bank) {
        super(name, age, idNumber, occupation, jobSeniority, creditScore, wage, bank);
    }

    //Methods
    public void increaseMinimumWages() {
        Double minimumWage = this.getBank().getBankWorkerSet()
                .stream()
                .map(BankWorker::getWage)
                .min(Double::compare)
                .get();

        this.getBank().getBankWorkerSet()
                .stream()
                .filter(worker -> minimumWage.compareTo(worker.getWage()) == 0)
                .forEach(worker -> worker.setWage((worker.getWage()) * 1.05));
    }

    public void increaseAllWages() {
        this.getBank().getBankWorkerSet()
                .forEach(worker -> worker.setWage(10));
    }

    public void increaseWagesLargerThan(double wage) {
        this.getBank().getBankWorkerSet()
                .stream()
                .filter(worker -> worker.getWage() < wage)
                .forEach(worker -> worker.setWage(10));
    }

    public void increaseCreditScoreByMinimum(int minimumCreditScore) {
        this.getBank().getAccountIDClientMap().entrySet()
                .stream()
                .filter(accountID -> minimumCreditScore < accountID.getValue().getCreditScore())
                .forEach(accountID -> {
                    accountID.getValue().setCreditScore(accountID.getValue().getCreditScore() + 10);
                });
    }

    public int signUpCreditScoreBonus(int clientID) {
        Client client = this.getBank().getAccountIDClientMap().values()
                .stream()
                .filter(newClient -> newClient.getClientID() == clientID)
                .findFirst()
                .get();

        int bonus = client.getCreditScore()
                + client.getOccupation().getCreditScoreModifier() * client.getJobSeniority().getCreditScoreModifier();
        client.setCreditScore(bonus);
        return bonus;
    }
}
