package recursion.level1;

public class CountZero1 {

    public static int count(int n, int count){
        if(n == 0){
            return count;
        }

        /**
         * It is just re-calling the method with updated value of the counter. The return statement is just to propagate
         * the last returned value from the base condition up the stack finally to the main method.
         */
        if(n % 10 == 0){
            return count(n/10, count+1);
        }

        return count(n/10, count);


    }

    public static void main(String[] args) {
        System.out.println(count(900987000, 0));
    }
}
