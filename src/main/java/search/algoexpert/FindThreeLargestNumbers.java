package search.algoexpert;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] arr = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int j : array) {
            if (j > arr[2]) {
                arr[0] = arr[1];
                arr[1] = arr[2];
                arr[2] = j;
            } else if (j > arr[1]) {
                arr[0] = arr[1];
                arr[1] = j;
            } else if (j > arr[0]) {
                arr[0] = j;
            }
        }
        return arr;
    }
}
