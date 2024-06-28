package practice;

public class NoOfStepsToMakeZero {

    public static int calculateSteps(int n){
        return helper(n, 0);
    }

    private static int helper(int n, int count){

        if(n == 0){
            return count;
        }

        if(n % 2 == 0){
            return helper(n/2, count+ 1);
        }else {
            return helper( n-1, count + 1);
        }

    }


    public static void main(String[] args) {
        System.out.println(calculateSteps(8));
    }
}
