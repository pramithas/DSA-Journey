package recursion.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Revised on dec 22.
 */
public class SubsequenceWithDuplicate {

    public static void main(String[] args) {
        int arr[] = {1,2,2};
        System.out.println(Arrays.toString(subsetWithoutDuplicates(arr).toArray()));
    }

    public static List<List<Integer>> subsetWithoutDuplicates(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {

            start = 0;

            int n = outer.size();

            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;

            for (int j = start; j < n; j++) {
                List<Integer> innerList = new ArrayList<>(outer.get(j));
                innerList.add(nums[i]);
                outer.add(innerList);
            }
        }

        return outer;
    }
}
