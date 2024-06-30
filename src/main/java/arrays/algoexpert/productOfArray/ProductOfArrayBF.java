package arrays.algoexpert.productOfArray;

public class ProductOfArrayBF {

    public int[] arrayOfProducts(int[] array) {

        if (array.length == 1) {
            return new int[]{array[0]};
        }

        int[] result = new int[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            int pointer = 0;
            int prod = 1;
            while (pointer < array.length) {
                if (pointer != i) {
                    prod *= array[pointer];
                }
                pointer++;
            }
            result[counter++] = prod;
        }
        return result;
    }
}
