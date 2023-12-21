package recursion.level1.reverse;

/**
 * Revised on december, 21.
 */
public class Reverse1 {

    public static int rev(int n, int noDigits){

        if(noDigits == 1){
            return n;
        }
        return (int) ((n % 10) * Math.pow(10, noDigits-1) + rev(n/10, noDigits - 1));
    }

    public static void main(String[] args) {
        int reversed = rev(1234567, 7);
        System.out.println(reversed);
    }
}
