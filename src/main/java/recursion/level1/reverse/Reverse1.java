package recursion.level1.reverse;

public class Reverse1 {

    public static int rev(int n, int noDigits){

        if(noDigits == 1){
            return n;
        }
        return (int) ((n % 10) * Math.pow(10, noDigits-1) + rev(n/10, noDigits - 1));
    }
}
