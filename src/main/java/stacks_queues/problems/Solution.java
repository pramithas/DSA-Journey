package stacks_queues.problems;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    // This is a brute force solution.
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0, 0);
    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {

        if (sum > maxSum) {
            return count - 1;
        }

        if (a.isEmpty() || b.isEmpty()) {
            return count;
        }

        int first = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.getFirst(), count + 1);
        int second = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.getFirst(), count + 1);

        return Math.max(first, second);
    }

    public static void main(String[] args) throws IOException {
        int counts = twoStacks(60, Arrays.asList(17, 5, 0), Arrays.asList(10, 8, 2, 1, 13, 1, 14, 18, 16, 19, 5));
        System.out.println(counts);
    }
}
