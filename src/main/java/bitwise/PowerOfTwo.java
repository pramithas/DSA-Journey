package bitwise;

/**
 * Write a program that checks if a number if power of two
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(33));
    }
}
