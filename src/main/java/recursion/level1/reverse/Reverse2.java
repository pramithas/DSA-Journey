package recursion.level1.reverse;

public class Reverse2 {
    public static int rev(int n, int sum){

        if(n == 0){
            return sum;
        }
        int rem = n % 10;
        sum = sum * 10+ rem;
        return rev(n/10, sum);
    }


    public static void main(String[] args) {
        System.out.println(rev(1234567, 0));
    }
}
