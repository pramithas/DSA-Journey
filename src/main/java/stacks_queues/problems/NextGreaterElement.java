package stacks_queues.problems;

import java.util.Arrays;

/**
 * This is not an optimized solution.
 */
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] array) {

        int[] result = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            while (i != j % array.length && array[j % array.length] <= array[i]) {
                j++;
            }
            if (array[i] != array[j % array.length]) {
                result[count++] = array[j % array.length];
            } else {
                result[count++] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
