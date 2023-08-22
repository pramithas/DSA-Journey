package recursion.level1;

public class Concept {

    public static void display(int n){

        if(n ==0 ){
            return;
        }

        System.out.println(n);

        display(--n);

        System.out.println(n);
    }

    public static void main(String[] args) {
        display(3);
    }
}
