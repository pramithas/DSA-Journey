package arrays.algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int index = 0;

        for (Integer elem : array) {

            if (Objects.equals(elem, sequence.get(index))) {
                index++;
            }

            if (index == sequence.size()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList( 6, 1, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}
