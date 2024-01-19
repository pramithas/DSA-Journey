package arrays.kunal;


import java.util.Arrays;

public class ReverseArray {

    static void reverse(int [] arr){

        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println("Before reversing: "+ Arrays.toString(arr));
        reverse(arr);
        System.out.println("After reversing: "+ Arrays.toString(arr));
    }
}
