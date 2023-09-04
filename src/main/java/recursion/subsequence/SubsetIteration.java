package recursion.subsequence;

import java.util.*;

public class SubsetIteration {

    public static void main(String[] args) {
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

    public static List<List<Integer>> findSubsetsHandleDuplicates(int[] nums) {

        Set<String> mySet = new HashSet<>();
        mySet.add("S");

        Arrays.sort(nums);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int previous = -1;
        for (int elem : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                if (elem == previous) {
                    continue;
                }
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(elem);
                outer.add(inner);
            }
            previous = elem;
        }

        return outer;
    }
}
