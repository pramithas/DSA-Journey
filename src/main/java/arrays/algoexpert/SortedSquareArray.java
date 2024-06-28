package arrays.algoexpert;

import java.util.Arrays;

public class SortedSquareArray {

    /**
     * We start populating result from the last array because if the first number is negative, its square will be the largest number.
     * We are using two pointer approach here.
     *
     * At each iteration, we have to determine which is the largest number. The square of the first index or
     * square of the last index.
     */
    public static int[] sortedSquaredArray(int[] array) {
        int lastIdx = array.length - 1;
        int firstIdx = 0;
        int[] result = new int[array.length];
        int counter = 1;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[firstIdx]) < Math.abs(array[lastIdx])) {
                result[array.length - counter] = array[lastIdx] * array[lastIdx];
                lastIdx--;
            } else {
                result[array.length - counter] = array[firstIdx] * array[firstIdx];
                firstIdx++;
            }
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-2, -1, 0, 1, 2};
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
    }
}
