package arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            int leftPointer = i + 1;
            int rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                if (array[i] + array[leftPointer] + array[rightPointer] == targetSum) {
                    result.add(new Integer[]{array[i], array[leftPointer], array[rightPointer]});
                    leftPointer++;
                    rightPointer--;
                } else if ((array[i] + array[leftPointer] + array[rightPointer]) < targetSum) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }
        return result;
    }
}
