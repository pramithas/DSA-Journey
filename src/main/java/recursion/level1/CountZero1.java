package recursion.level1;

/**
 * Counts the number of zero in the given number.
 * Revised on : 10th December, 2023.
 */
public class CountZero1 {

    public static int count(int n, int count) {

        /*
            Can't simply use count+1 to handle the edge case when the number is zero. It is because, this base condition is also
            encountered when a large number gets reduced step by step and become zero. In that case, we cannot do count + 1;
         */
        if (n == 0) {
            return count;
        }

        /*
         * It is just re-calling the method with updated value of the counter. The return statement is just to propagate
         * the last returned value i.e. the total count value from the base condition up the stack finally to the main method.
         */
        if (n % 10 == 0) {
            return count(n / 10, count + 1);
        }

        return count(n / 10, count);


    }

    public static void main(String[] args) {
        System.out.println(count(1200230003, 0));
    }
}
