package bitwise;

/**
 * Write a program to find nth magic number.
 */
public class MagicNumber {

    public static int findMagicNumber(int n){
        int magicNumber = 0;
        int counter = 1;
        while(n > 0){
            int lastDigit = n & 1;
            magicNumber += lastDigit * (Math.pow(5, counter++));
            n = n >> 1;
        }
        return magicNumber;
    }

    public static void main(String[] args) {
        System.out.println(findMagicNumber(5));
    }
}
