package homework1.task3.selectionsort;
/*
3) Task 3
You have array of numbers [3, 7, 6, 13, 33, 9, -100, 25]
Sort this array using one of sorting algorithms: Insertion sort, Selection sort, Bubble sort.
- Vilchez Maximiliano: SELECTION SORT
 */

public class Task3 {
    public static void main(String[] args) {
        int[] array= {3, 7, 6, 13, 33, 9, -100, 25};
        int minIndex=0;
        int i=0;
        int j=0;

        while (i<array.length-1){
            minIndex=i;
            j=i+1;
            while(j<array.length){
                if(array[j]<array[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            swap(array,minIndex,i);
            i++;
        }
        for(int k=0;k< array.length;k++){
            System.out.print(array[k]+"\t");
        }
    }
    public static void swap(int[] array,int minIndex, int smallestIndex){
        int temp=array[minIndex];
        array[minIndex]=array[smallestIndex];
        array[smallestIndex]=temp;



    }
}