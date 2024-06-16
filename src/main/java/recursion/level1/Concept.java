package recursion.level1;

/**
 * Revised on 10th december, 2023.
 */
public class Concept {

    public static void display(int n){

        if(n ==0 ){
            return;
        }

        System.out.println(n);
        // 2,1,0
        // first decrease by 1 and call the method.
        display(--n);

        //System.out.println(n);
        // 0,1,2
    }

    public static void main(String[] args) {
        display(3);
    }
}
