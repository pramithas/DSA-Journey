package maths;

/**
 * Write a program to find the number of digits of a given number in particular base.
 */
public class NoOfDigitsInBaseB {

    public static int getNumberOfDigits(int n, int base){
        return (int) (Math.log10(n)/Math.log10(base))+1;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfDigits(4,2));
    }
}
