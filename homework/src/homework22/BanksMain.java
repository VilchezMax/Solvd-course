package homework22;

import homework22.models.Client;
import homework22.models.Guest;

import java.util.Scanner;

/*
I. Create a classes hierarchy.
It should include at least 10 classes
Vilchez Maximiliano - Banks
- I want to get a credit, is it possible or not?
- I want to make some bank operations also want to have them implemented in the bank
II. Override methods from class Object(toString, hashcode, equals) for at least 3 classes from the hierarchy.
*/
public class BanksMain {
    Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
         //*1) Create guest, check eligibility NOT POSSIBLE
        Guest guest1 = new Guest("Dzmitry",28,10,"Automation Engineer",100);
        guest1.isElegibilityForCredit();
         //*2) Create Client 1, check eligibility NOT POSSIBLE, bronze and <50
        Client client1 = new Client("Max",27,38789789,"QA TA Engineer",
                            49,11,754963,false,"Solvd Arg HQ");
         //*3) Create Client 2, check eligibility YES, tier:solvd
        Client client2 = new Client("Sergei",30,12,"Team lead QA",
                            400,80,7893148,true,"Solvd Main HQ");
         //*4) Client 2 deposits in account. account + balance
         //*5) Cliente 2 transfers to Client 1
         //*6)
         //*7)
         //*8)
         //*9)
         //*10)

    }
}
/* LEND(), if eligibility is true -> lend.
 * OPERATIONS: Transfer, deposit. Bank implements Transfer, Deposits
 * CLASSES: ACCOUNT.id
 */