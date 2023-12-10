package Arrays;

/**
 * Revision date: 10th December, 2023.
 */
public class FindIfArrayIsSortedOrNot {

    public static boolean isSorted(int arr[]) {

        if (arr.length == 0) {
            return false;
        }

        if (arr.length == 1) {
            return true;
        }

        return helper(0, arr.length - 1, arr);

    }

    /*
        You can start comparing in left to right order as well.
     */
    private static boolean helper(int start, int end, int[] arr) {

        if (start == end) {
            return true;
        }
        // December 10, 2023.
        // Basically, we are checking every element with the previous one if the previous one is smaller or equal. And, we are making each
        // check in a different recursive call.

        if (arr[end] >= arr[end - 1]) {
            // If the current check passes, check the remaining numbers as well. i.e. propagate the value up the call stack, nothing else.
            return helper(start, end - 1, arr);
        } else {
            return false;
        }
    }

    public static boolean isSortedV1(int arr[], int index) {

        if (index == arr.length - 1) {
            return true;
        }

        // This provides short circuit i.e. if the first condition is false, it won't bother with the recursion.
        return arr[index] < arr[index + 1] && isSortedV1(arr, index + 1);
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 4, 5, 6};
        System.out.println(isSortedV1(arr, 0));
    }
}
