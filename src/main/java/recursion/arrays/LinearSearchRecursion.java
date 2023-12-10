package recursion.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Revised on 10th December, 2023.
 */
public class LinearSearchRecursion {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 4, 4, 45, 56, 6, 67, 67};
        System.out.println(findAllIndices2(arr, 4));
    }

    private static int search(int[] arr, int target) {

        int index = 0;
        return helper(arr, target, index);
    }

    private static List<Integer> findAllIndices(int[] arr, int target) {
        int index = 0;
        List<Integer> indices = new ArrayList<>();
        return helper1(arr, target, index, indices);
    }

    private static List<Integer> findAllIndices2(int[] arr, int target) {
        int index = 0;
        return helper2(arr, target, index);
    }

    private static List<Integer> helper2(int[] arr, int target, int index) {

        List<Integer> indices = new ArrayList<>();

        /*
         * This will be the belowans for the method calling it. It will never have the value for indices.
         */
        if (index == arr.length) {
            return indices;
        }

        if (arr[index] == target) {
            indices.add(index);
        }

        // acts as the bridge to return the indices returned from the base condition.
        List<Integer> belowAns =  helper2(arr, target, index + 1);
        indices.addAll(belowAns);
        return indices;

    }

    private static List<Integer> helper1(int[] arr, int target, int index, List<Integer> indices) {

        /**
         * Two base conditions. One of the two base cases with return.
         */
        if (index == arr.length) {
            return indices;
        }

        if (arr[index] == target) {
            indices.add(index);
        }

        // acts as the bridge to return the indices returned from the base condition.
        return helper1(arr, target, index + 1, indices);
    }

    private static int helper(int[] arr, int target, int index) {

        /**
         * Two base conditions. One of the two base cases with return.
         */
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return helper(arr, target, index + 1);
    }
}
