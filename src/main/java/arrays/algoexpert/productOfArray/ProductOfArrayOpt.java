package arrays.algoexpert.productOfArray;

import java.util.Arrays;

public class ProductOfArrayOpt {
    public static int[] arrayOfProducts(int[] array) {

        int[] result = new int[array.length];

        int leftProduct[] = new int[array.length];
        int rightProduct[] = new int [array.length];

        leftProduct[0] = 1;
        rightProduct[array.length - 1] = 1;

        for(int i = 1; i < array.length; i++){
            leftProduct[i] = leftProduct[i - 1] * array[i - 1];
        }

        for(int j = array.length - 2 ; j >= 0; j--){
            rightProduct[j] = rightProduct[j + 1] * array[j + 1];
        }

        for(int i = 0; i < array.length; i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {5,1,4,2};
        System.out.println(Arrays.toString(arrayOfProducts(a)));
    }
}
