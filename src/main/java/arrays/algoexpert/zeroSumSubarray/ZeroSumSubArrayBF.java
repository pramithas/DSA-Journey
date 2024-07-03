package arrays.algoexpert.zeroSumSubarray;

public class ZeroSumSubArrayBF {

    public boolean zeroSumSubarray(int[] nums) {

        if (nums.length == 0 || nums[0] == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            if (nums[i] == 0) {
                return true;
            }

            int a = i;

            while (a < nums.length) {
                sum += nums[a];
                if (sum == 0) {
                    return true;
                }
                a++;
            }
        }
        return false;
    }
}
