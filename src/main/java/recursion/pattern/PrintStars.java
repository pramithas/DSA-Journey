package recursion.pattern;


import java.util.Arrays;

public class PrintStars {

    public static void printStars(int r, int c) {

        if (r == 0) {
            return;
        }

        // By changing the position of the print statement(before or after the recursive call,
        // you can revert the pattern)
        if (c < r) {
            printStars(r, c + 1);
            System.out.print("*");
        } else {
            printStars(r - 1, 0);
            System.out.println();
        }
    }

    /**
     * Here r basically signifies the number of comparisons to be made.
     *
     * @param arr
     * @param r
     * @param c
     */
    public static void bubbleSort(int[] arr, int r, int c) {

        if (r == 0) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubbleSort(arr, r, c + 1);
        } else {
            bubbleSort(arr, r - 1, 0);
        }
    }

    /*
    Do not refer this approach.
     */
    public static void selectionSort(int arr[], int r, int c, int max) {

        if (r == 0) {
            return;
        }

        if(c > r){
            //set the max element at the end of the array.
            int temp = arr[r];
            arr[r] =  arr[max];
            arr[max] = temp;
        }

        if (c <= r) {
            if (arr[c] >= arr[max]) {
                max = c;
            }
            selectionSort(arr, r, c + 1, max);
        } else {
            selectionSort(arr, r - 1, 0, 0);
        }
    }

    /*
    Refer this approach.
     */
    public static void selectionSort2(int[] arr, int r, int c, int max) {

        if (r == 0) {
            return;
        }

        /*
         * We are just incrementing the column by 1 and storing the max value.
         */
        if (c <= r) {
            if (arr[c] > arr[max]) {
                selectionSort2(arr, r, c + 1, c);
            }else {
                selectionSort2(arr, r, c + 1, max);
            }

        } else {
            int temp = arr[r];
            arr[r] =  arr[max];
            arr[max] = temp;
            selectionSort2(arr, r - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 7, 1,4,1,1,5,6};
        selectionSort2(arr, arr.length-1, 0,0);
        System.out.println(Arrays.toString(arr));
        //printStars(5,0);
    }
}
