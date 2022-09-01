package hometasks.hw1algorithms.task3.selectionsort;
/*
3) Task 3
You have array of numbers [3, 7, 6, 13, 33, 9, -100, 25]
Sort this array using one of sorting algorithms: Insertion sort, Selection sort, Bubble sort.
- Vilchez Maximiliano: SELECTION SORT
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {3, 7, 6, 13, 33, 9, -100, 25};
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }

        for (int k : array) {
            System.out.print(k + "\t");
        }
    }

    public static void swap(int[] array, int minIndex, int smallestIndex) {
        int temp = array[minIndex];
        array[minIndex] = array[smallestIndex];
        array[smallestIndex] = temp;
    }
}