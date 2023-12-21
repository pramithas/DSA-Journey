package recursion.level1;

/**
 * Revised on december, 21.
 */
public class PrintFromNTo1 {

    static void printNTo1(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printNTo1(n - 1);
    }

    public static void main(String[] args) {
        printNTo1(5);
        //print1To5(5);
    }

    private static void print1To5(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }

        print1To5(n - 1);
        System.out.println(n);
    }
}
