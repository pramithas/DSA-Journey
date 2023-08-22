package recursion;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int arr[], int target) {

        int start = 0;
        int end = arr.length - 1;

        Arrays.sort(arr);
        return search(start, end, arr, target);
    }

    private static int search(int start, int end, int arr[], int target) {

        int mid = start + (end - start) / 2;

        if(start > end){
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        // return statement will return the value up the stack.
        return search(start, end, arr, target);
    }


    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 7, 8, 9};
        int target = 5;
        System.out.println(binarySearch(arr, target));
    }
}
