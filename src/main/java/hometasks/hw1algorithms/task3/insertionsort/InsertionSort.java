package homework1.task3.insertionsort;
/*
3) Task 3
You have array of numbers [3, 7, 6, 13, 33, 9, -100, 25]
Sort this array using one of sorting algorithms: INSERTION SORT
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array= {3, 7, 6, 13, 33, 9, -100, 25};

        for (int i=1;i<array.length;i++){
            int key = array[i];
            int j = i-1;

            while(j>=0 && array[j] > key){
                array[j+1]=array[j];
                j=j-1;
            }
            array[j+1]=key;
        }
        for(int k:array){
            System.out.print(k+ "\t");
        }
    }
}
