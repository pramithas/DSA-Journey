package recursion.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperSet {
    public static List<List<Integer>> powerset(List<Integer> array) {

        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());

        for (Integer num : array) {

            // No need to maintain a separate subset list since power set will also contain
            // all the subsets.
            int size = powerSet.size();

            for (int i = 0 ; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(powerSet.get(i));
                newSubset.add(num);
                powerSet.add(newSubset);
            }
        }
        return powerSet;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3);
        System.out.println(powerset(input));
    }

}
