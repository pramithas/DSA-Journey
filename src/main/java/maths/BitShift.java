package maths;

public class BitShift {

    public static int leftShift(int n, int shift){
        return n << shift;
    }

    public static int rightShift(int n, int shift){
        return n >> shift;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(leftShift(n,2));
        System.out.println(rightShift(n, 2));
    }
}
