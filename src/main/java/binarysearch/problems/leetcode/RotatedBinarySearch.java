package binarysearch.problems.leetcode;

public class RotatedBinarySearch {

    public static void main(String[] args) {

        int arr[] = {6, 7, 1, 2, 3, 4, 5};

        System.out.println(rotatedBinarySearch(arr, 6));
    }

    private static int rotatedBinarySearch(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }

        int peakIndex = findPeakIndex(nums);

        int ans = bs(nums, 0, peakIndex, target);
        if (ans == -1) {
            ans = bs(nums, peakIndex + 1, nums.length - 1, target);
        }
        return ans;
    }

    static int bs(int[] arr, int start, int end, int target) {
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

    private static int findPeakIndex(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else if (arr[start] < arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int findPeakIndexWithDuplicates(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            //skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //Note: what if the start and end elements are the pivot elements?? So, check if they are pivot.
                // Check if start is pivot.
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Check if end-1 is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;

            }
            // left side is sorted, so pivot should be in right.
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }
}
