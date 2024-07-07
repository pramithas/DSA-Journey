package sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to partition the array on the basis of pivot element
    public static int partition(int[] arr, int low, int high) {
        // Pivot element is the first element
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            // Increment left index while elements are smaller than the pivot
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            // Decrement right index while elements are greater than the pivot
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            // Swap elements at left and right indices
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // Swap pivot element with element at right index
        swap(arr, low, right);
        return right;
    }

    // Function to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        System.out.println(Arrays.toString(quickSort(arr)));
    }
}
