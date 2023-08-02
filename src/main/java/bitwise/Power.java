package bitwise;

/**
 * Write a program to power a number to a given number
 */
public class Power {

    public static int findPower(int base, int power){

        int ans = 1;

        while(power > 0){
            if((power & 1) == 1){
                ans *= base;
            }

            base *= base;
            power = power >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findPower(2,5));
    }
}
