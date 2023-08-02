package maths;

public class SqaureRoot {

    static double sqrt(int n, int p){

        int s = 0;
        int e = n;

        double root = 0.0;

        while(s <= e){
            int m = s+ (e-s)/2;

            if(m*m == n){
                System.out.println("Square root found: "+ m);
            } else if (m * m < n) {
                s = m+1;
            }else {
                e = m-1;
            }
        }

        // Why can't it be root = s?. May be the loop ends after s > e, so the s is not holding a valid value.??
        root = e;

        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while(root  * root <= n){
                root += incr;
            }

            root -= incr;
            incr /= 10;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(50,3));
    }
}
