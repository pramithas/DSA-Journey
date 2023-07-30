package maths;

public class FindOddNumber {

    static boolean  isOdd(int x){
        return (x & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println("4 is odd: "+ isOdd(4));
        System.out.println("5 is odd: "+ isOdd(5));
    }
}
