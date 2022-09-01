package hometasks.hw1algorithms.task1;
/*
1) Task 1
Create simple java class with main method that prints some text.
Parse array from main method arguments and print its first element.
Compile and run your class from command line.
 */

public class Task1 {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("Print this:" + arg);
        }

    }

    //Alternative
    public static void main2(String[] args2) {
        for (int i = 0; i < args2.length; i++) {
            System.out.println("Print this:" + args2[i]);
        }

    }

}

//Compile: javac src/Task1/Task1.java
//Run: java src/Task1/Task1.java whatever-you-want-to-print