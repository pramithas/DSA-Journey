package arrays.algoexpert.productOfArray;

import java.util.Arrays;

public class ProductOfArrayOpt {
    public static int[] arrayOfProducts(int[] array) {

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            int leftProd = 1;
            int rightProd = 1;

            int leftPointer = i - 1;
            int rightPointer = i + 1;

            while (leftPointer >= 0){
                leftProd*= array[leftPointer--];
            }

            while (rightPointer < array.length){
                rightProd*= array[rightPointer++];
            }

            result[i] = leftProd * rightProd;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {5,1,4,2};
        System.out.println(Arrays.toString(arrayOfProducts(a)));
    }
}
