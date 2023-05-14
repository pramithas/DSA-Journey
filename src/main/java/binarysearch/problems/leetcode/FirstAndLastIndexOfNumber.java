package binarysearch.problems.leetcode;

import java.util.Arrays;

public class FirstAndLastIndexOfNumber {

    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(firstAndLastIndex(arr, 8)));
    }

    private static int[] firstAndLastIndex(int[] arr, int i) {
        int firstIndex = searchFirstIndex(arr, i);
        int lastIndex = searchLastIndex(arr, i);
        return new int[]{firstIndex, lastIndex};
    }

    private static int searchLastIndex(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if(target > arr[mid]){
                start = mid + 1;
            }else if(target == arr[mid]){
                // mid might be the start index
                start = mid + 1;
                ans = mid;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static int searchFirstIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }else if(target == arr[mid]){
                // mid might be the start index
                end = mid -1;
                ans = mid;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
