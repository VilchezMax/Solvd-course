package com.banking.models.humans;

import java.util.PriorityQueue;
import java.util.Queue;


public final class BankDoorman extends BankWorker {

    Queue<Person> bankQueue = new PriorityQueue<Person>(100, (Person o1, Person o2) -> {

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

    public Queue<Person> getBankQueue() {
        return bankQueue;
    }

    public void setBankQueue(Queue<Person> bankQueue) {
        this.bankQueue = bankQueue;
    }

    //Methods

    public int compareAge(Person p1, Person p2) {
        if (p1.getAge() == p2.getAge()) {
            return 0;
        } else if (p1.getAge() == p2.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
}
