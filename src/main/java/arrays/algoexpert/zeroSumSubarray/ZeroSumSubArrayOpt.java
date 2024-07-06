package arrays.algoexpert.zeroSumSubarray;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArrayOpt {

    public static boolean zeroSumSubArray(int[] nums) {

        int sum = 0;
        Set<Integer> sumSet = new HashSet<>();

        for (int num : nums) {
            sum += num;
            if (num == 0 || sum == 0 || !sumSet.add(sum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {0,0,0};
        zeroSumSubArray(input);
    }
}
