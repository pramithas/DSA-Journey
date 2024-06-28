package arrays.algoexpert;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/non-constructible-change
 */
public class NonConstructibleChange {

    // Write your code here.
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.

        Arrays.sort(coins);

        int sum = 0;

        for (int i = 0; i < coins.length; i++) {

            if (coins[i] > (sum + 1)) {
                return sum + 1;
            }
            sum += coins[i];
        }
        return sum + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5};
        int result = new NonConstructibleChange().nonConstructibleChange(arr);
        System.out.println(result);
    }
}
