package com.banking.models.humans;

import java.util.PriorityQueue;
import java.util.Queue;

//TODO ASK SERGEI: why the parametrized type goes on class name?

public final class BankDoorman<T extends Person> extends BankWorker {

    Queue<T> bankQueue = new PriorityQueue<T>(100, (T o1, T o2) -> {

        /* Priorities:
         * Client vs Guest -> Both clients? Compare Tiers -> Same tier? Compare credit score -> Same conditions? Compare age
         */

        if (o1 instanceof Client && o2 instanceof Client) {
            if (((Client) o1).getAccountTier().getPriority()
                    == ((Client) o2).getAccountTier().getPriority()) {
                if (((Client) o1).getCreditScore() == ((Client) o2).getCreditScore()) {
                    compareAge(o1, o2);
                } else if (((Client) o1).getCreditScore() > ((Client) o2).getCreditScore()) {
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
        } else if (o1 instanceof Client && !(o2 instanceof Client)) {
            return -1;
        } else if (!(o1 instanceof Client) && o2 instanceof Client) {
            return 1;
        } else {
            compareAge(o1, o2);
        }
        return 0;
    });

    public Queue<T> getBankQueue() {
        return bankQueue;
    }

    public void setBankQueue(Queue<T> bankQueue) {
        this.bankQueue = bankQueue;
    }

    //Methods

    public int compareAge(T p1, T p2) {
        if (p1.getAge() == p2.getAge()) {
            return 0;
        } else if (p1.getAge() == p2.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
}
