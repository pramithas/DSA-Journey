package binarysearch.problems;

public class CeilingOfANumber {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 8, 9, 16, 19, 21};
        System.out.println(findCeil(arr, 66));
    }

    static int findCeil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
                // In this particular case, the mid-value can be the ceiling. So, we cache the mid value in case
                //we cannot find a new ceiling in the left of mid.
                ans = arr[mid];
            }
        }
        return ans;
    }
}
