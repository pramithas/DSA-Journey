package recursion.mergesort;

import java.util.Arrays;

public class MergeSortIterative {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 10, 56, 27, 18, 32};
        int low = 0;
        int high = arr.length - 1;
        int mid = high / 2;
        merge(arr, low, mid, high);
    }

    public static void merge(int[] Arr, int low, int mid, int high) {
        int[] arr_left = new int[mid - low + 1];
        int[] arr_right = new int[high - mid];
        for (int i = 0; i < Arr.length; i++) {
            if (i <= mid) {
                arr_left[i] = Arr[low + i];
            }
            else {
                System.out.printf("i = %d , mid = %d%n", i, mid);
                arr_right[i] = Arr[mid + 1 + i];
            }
        }
        System.out.println(Arrays.toString(arr_left));
        System.out.println(Arrays.toString(arr_right));
    }
}
