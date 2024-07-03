package arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

    public static Integer[][] mergeOverlappingIntervals(int[][] intervals) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {

            int first = intervals[i][0];
            int second = intervals[i][1];

            while (i < intervals.length - 1 && intervals[i + 1][0] >= first && intervals[i + 1][0] <= second) {
                second = Math.max(intervals[i + 1][1], second);
                i++;
            }

            List<Integer> res = new ArrayList<>();
            res.add(first);
            res.add(second);
            result.add(res);
        }
        Integer[][] array = new Integer[result.size()][];

        int i = 0;
        for (List<Integer> nestedList : result) {
            array[i++] = nestedList.toArray(new Integer[0]);
        }

        return array;
    }

    public static void main(String[] args) {
        int[][] array =
                {{1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}};
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(array)));
    }
}
