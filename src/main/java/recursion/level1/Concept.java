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
        // first decrease by 1 and call the method.
        display(--n);

        System.out.println(n);
    }

    public static void main(String[] args) {
        display(3);
    }
}
