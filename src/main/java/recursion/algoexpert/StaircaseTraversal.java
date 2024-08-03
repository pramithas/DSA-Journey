package recursion.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal {

    // Using a map to store the results for different heights
    private static Map<Integer, Integer> memoization = new HashMap<>();

    public static int staircaseTraversal(int height, int maxSteps) {
        // Base cases
        if (height == 0) {
            return 1;
        }
        if (height < 0) {
            return 0;
        }

        // Check if the result for the current height is already computed
        if (memoization.containsKey(height)) {
            return memoization.get(height);
        }

        int totalWays = 0;
        // Iterate through all possible steps
        for (int step = 1; step <= maxSteps; step++) {
            totalWays += staircaseTraversal(height - step, maxSteps);
        }

        // Store the result in the map for future reference
        memoization.put(height, totalWays);
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(10, 1));
    }
}
