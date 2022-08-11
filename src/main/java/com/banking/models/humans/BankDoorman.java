package com.banking.models.humans;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BankDoorman extends BankWorker{
    Queue<Person> bankQueue = new PriorityQueue<>(100, new Comparator<Person>() {

        /* Priorities:
         * Client vs Guest -> Both clients? Compare Tiers -> Same tier? Compare credit score -> Same conditions? Compare age
         */

        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getClass() == Client.class && o2.getClass() == Client.class){
                    if(Client.getTierOfClientAccount(((Client) o1)).getPriority()
                    == Client.getTierOfClientAccount(((Client) o2)).getPriority()){
                            if(((Client) o1).getCreditScore() == ((Client) o2).getCreditScore()) {
                                compareAge(o1,o2);
                            } else if (((Client) o1).getCreditScore()>((Client) o2).getCreditScore()){
                                return -1;
                            } else {
                                return 1;
                            }
                    } else if (Client.getTierOfClientAccount(((Client) o1)).getPriority()
                             > Client.getTierOfClientAccount(((Client) o2)).getPriority()){
                        return -1;
                    } else {
                        return 1;
                    }
            } else if (o1.getClass() == Client.class && o2.getClass() != Client.class){
                return -1;
            } else if (o1.getClass() != Client.class && o2.getClass() == Client.class){
                return 1;
            } else {
                compareAge(o1,o2);
            }
            return 0;
        }

        public int compareAge(Person p1, Person p2){
            if(p1.getAge() == p2.getAge()){
                return 0;
            } else if (p1.getAge() == p2.getAge()){
                return -1;
            } else {
                return 1;
            }
        }
    });


}
