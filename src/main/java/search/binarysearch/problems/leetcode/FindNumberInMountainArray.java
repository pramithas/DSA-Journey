package search.binarysearch.problems.leetcode;

import static search.binarysearch.problems.leetcode.PeakIndexInMountainArray.findPeakIndex;

public class FindNumberInMountainArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 4, 3};
        int index = findIndexOf(arr, 3);
        System.out.println(index);
    }

    private static int findIndexOf(int[] arr, int i) {
        int peakIndex = findPeakIndex(arr);
        int ans = search(arr, 0, peakIndex, i);
        if (ans == -1) {
            ans = search(arr, peakIndex + 1, arr.length - 1, i);
        }
        return ans;
    }

    static int search(int[] arr, int start, int end, int target) {
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
