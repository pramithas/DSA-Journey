package recursion.level1;

/**
 * Number of steps required to make a number zero by dividing by 2 continuously. If it is not divisible by 2,make it so by subtracting 1 from it.
 * Revised on December 10, 2023.
 */
public class NoOfStepsToMakeNumberZero {

    public static int countSteps(int n) {
        int steps = 0;
        return helper(n, steps);
    }

    private static int helper(int n, int steps) {
        if (n == 0) {
            return steps;
        }

        if (n % 2 == 0) {
            return helper(n / 2, steps + 1);
        } else {
            return helper(n - 1, steps + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(countSteps(8));
    }
}
