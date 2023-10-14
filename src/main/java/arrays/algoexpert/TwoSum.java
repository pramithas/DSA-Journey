package arrays.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Set<Integer> integerSet = new HashSet<>();

        for (int elem : array) {
            integerSet.add(elem);
        }

        for (int elem : array) {
            if (integerSet.contains(targetSum - elem)) {
                return new int[]{elem, targetSum - elem};
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumVersion2(int[] array, int targetSum) {

        Set<Integer> integerSet = new HashSet<>();

        for (int elem : array) {
            if (integerSet.contains(targetSum - elem)) {
                return new int[]{elem, targetSum - elem};
            }else {
                integerSet.add(elem);
            }
        }
        return new int[0];
    }
}
