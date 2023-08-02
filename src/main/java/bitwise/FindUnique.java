package bitwise;

/**
 * Bitwise XOR operation.
 * Find unique in a an array where every other number has a duplicate.
 */
public class FindUnique {

    public static int findUnique(int[] arr){
        int unique = 0;
        for(int elem: arr){
            unique ^= elem;
        }
        return unique;
    }


    public static void main(String[] args) {
        int arr[] = {2,3,3,4,2,6,4,6,7};
        int uniqueNumber = findUnique(arr);
        System.out.println(uniqueNumber);
    }
}
