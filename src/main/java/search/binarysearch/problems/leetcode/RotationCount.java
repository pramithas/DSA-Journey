package search.binarysearch.problems.leetcode;

public class RotationCount {

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(rotationCount(arr));
    }

    static final int rotationCount(int[] nums) {
        return findPeakIndex(nums) + 1;
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
}
