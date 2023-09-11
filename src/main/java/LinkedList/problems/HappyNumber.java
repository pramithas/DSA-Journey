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
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }
        return false;
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
