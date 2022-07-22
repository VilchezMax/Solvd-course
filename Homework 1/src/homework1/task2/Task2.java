/*
2) Task 2
You have an array of numbers [3, 7, 6, 13, 33, 9, -100, 25]
Print all the values of array using while loop.
In the same loop find the biggest and the smallest value of an array and then print values afterwards.
 */
package homework1.task2;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {3,7,6,13,33,9,-100,25};
        int counter=0;
        int biggest=0;
        int smallest=0;
        while(counter<array.length){
            if(counter==0){
                biggest=array[counter];
                smallest=array[counter];
            } else {
                if(array[counter]>biggest){
                    biggest=array[counter];
                } else if (array[counter]<smallest){
                    smallest=array[counter];
                }
            }
            System.out.println(array[counter]);
            counter++;
        }
        System.out.println("-------------------");
        System.out.println("Biggest is: " + biggest);
        System.out.println("Smallest is: " + smallest);
    }
}
