package com.banking.models;

import com.banking.exceptions.UnregisteredException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Operation {
    private final int opID;
    double amount;

    public Operation(Bank bank) {
        this.opID = Operation.findMaxID(bank.getOperationList()) + 1;
        this.amount = 0;
    }

    public Operation(int opID, double amount) {
        this.opID = opID;
        this.amount = amount;
    }

    public static int findMaxID(ArrayList<Operation> list) {
        int max = 0;
        for (Operation op : list) {
            if (op.getOpID() > max) {
                max = op.getOpID();
            }
        }
        return max;
    }

    public Operation findOperationByID(Bank bank, int opId) throws UnregisteredException {
        Operation operation = (Operation) bank.getOperationList()
                .stream()
                .filter(opt -> opt.getOpID() == opId);

        if (operation == null) {
            Throwable e = new UnregisteredException();
            final Logger logger = LogManager.getLogger(Operation.class);
            logger.warn("Operation " + opID + " not found\n", e);
        }
        return operation;
    }

    public int getOpID() {
        return opID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return opID == operation.opID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opID);
    }
}
