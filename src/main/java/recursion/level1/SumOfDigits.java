package recursion.level1;

/**
 * Revised on dec, 21.
 * This is same as product of numbers.
 */
public class SumOfDigits {
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sum(1234));
    }
}
