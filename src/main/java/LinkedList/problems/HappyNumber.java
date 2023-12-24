package LinkedList.problems;

public class HappyNumber {

    public boolean isHappy(int n) {

        int fast = n;
        int slow = n;

        do {
            // Using same variable name in function argument and return value, automatically
            // reprocesses the value in the next loop.
            // It simulates the slow and fast pointers as well. Slow pointer is moving with 1 step and fast pointer with 2 steps.
            // The number itself is a pointer to itself.
            slow = findSumOfSquares(slow);
            fast = findSumOfSquares(findSumOfSquares(fast));
            // Why this condition is met when the number is happy number. We know this is met when the number is
            // not happy and there is cycle.
            // Ans: Because, even if the number is happy, there will be a cycle. And, the cycle will start at 1 and
            // the following nodes will be all 1.
        } while (fast != slow);

        return slow == 1;
    }

    public int findSumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {

            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}
