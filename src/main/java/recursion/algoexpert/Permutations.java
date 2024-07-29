package recursion.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if(array.isEmpty()){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPerm = new ArrayList<>();
        getPermutationsHelper(array, currentPerm, result);
        return result;
    }

    private static void getPermutationsHelper(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> perms) {
        if (array.isEmpty()) {
            perms.add(new ArrayList<>(currentPerm));
        } else {
            for (int i = 0; i < array.size(); i++) {
                int current = array.get(i);
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                currentPerm.add(current);
                getPermutationsHelper(newArray, currentPerm, perms);
                currentPerm.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3);
        System.out.println(getPermutations(array));
    }
}
