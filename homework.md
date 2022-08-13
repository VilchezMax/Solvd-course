/*

* TODO LIST:
* IMPORTANT:
* #### REFACTOR HIERARCHIES AS SERGEI SAID ON CLASS 3 VIDEO 26/07.
*          Guest att/meths are incomplete, should be elegible for credit and validated
*          why minor exist if it cant extend client/guest? doesnt do anything. Add a Tier for minor accounts.
*          better to implement class Person, extend to Workers/clients
*          Because if class is guest, cant turn into client, its better being an attribute "account null or xxxx"
* `if account null => guest`
* `if guest => no credit`
*
* IMPORTANT:
* #### REFACTOR STATIC METHODS TO INSTANCE METHODS WHEN APPROPIATE.
*      i.e: Client.checkEligibilityForCredit(client); -> client.checkEliginilityForCredit();
*      Static methods use them to search parameter on lists, better.
*
*      min 1:06:00 - Use interNetwork attribute for valdiations.
*      fix Sergei TIER in Account2, it prints BRONZE, it should print SOLVD.
*      fix amount offered for credit. it is way too large. search for mistake, so many 0's it prints "E".
*      move Credit to Operation Menu.
*
* ## HW3: Polimorphism
*     Use polymorphism with the abstract class from the hierarchy.
*     Create final class, method, variable.
*
* ## HW4: INTERFACES
*     Add 3 interfaces to existing hierarchy
*     Use polimorphism with an interface of the hierarchy
*     Create static block, method , variable
*
* ## HW5: EXCEPTIONS
* Task 1)
*      Create 5 custom exceptions
*      Handle exceptions 2 ways: throws and try/catch
* Task 2)
*      Improve your current classes hierarchy including next points:
*      Replace System.out.print() by “java.util.logging.Logger” usage.
*      Use different log levels.
*      Configure logging of messages to the console and file at the same time using Java logging configuration.
*
* ## HW6: COLLECTIONS
* Task 1)
*      Add 5 collections to your existent hierarchy (as attributes of your entity classes)
*      and methods for working with them (add,remove,replace,size, etc.)
* Task 2)
*      Create custom LinkedList with generic and use it as part of your hierarchy
*      usage pattern is the same and it's described above.
*
* ## CLASS 12/08 CRITICS:
*      Mistake Exception in main - CORRECTED
*      1:24:00 MAKE COLLECTIONS NOT STATIC, resolve branch stuff
*      1:25:22 DONT break encapsulation, Client cant call bank methods
*      1:36:00 Code "too direct" makes it easy to implement but will bring errors
*              It's Better to encapsulate good and call methods from where they should be declared
*              Even if that means that the method only calls another method.
*
*

*/