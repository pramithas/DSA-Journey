package recursion.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetIteration {

    public static void main(String[] args) {
        int str[] = {1, 2, 3};
        findSubsets(str);
    }

    public static void findSubsets(int arr[]) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int str : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(str);
                outer.add(inner);
            }
        }

        System.out.println(Arrays.toString(outer.toArray()));
    }
}
