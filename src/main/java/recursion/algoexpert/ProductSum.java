package recursion.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof List) {
                sum += productSum((List<Object>) o, depth + 1);
            } else {
                sum += (Integer) o;
            }
        }
        return depth * sum;
    }

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        List<Object> array1 = new ArrayList<>();
        array1.add(7);
        array1.add(-1);
        array.add(array1);
        array.add(3);
        List<Object> array2 = new ArrayList<>();
        array2.add(6);
        List<Object> array3 = new ArrayList<>();
        array3.add(-13);
        array3.add(8);
        array2.add(array3);
        array2.add(4);
        array.add(array2);

        System.out.println(productSum(array));
    }
}
