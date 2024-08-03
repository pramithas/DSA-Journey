package search.binarysearch.problems.leetcode;

import java.util.Arrays;

public class FirstAndLastIndexOfNumber {

    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(firstAndLastIndex(arr, 10)));
    }

    private static int[] firstAndLastIndex(int[] arr, int i) {
        int firstIndex = searchFirstOrLastIndex(arr, i, Boolean.TRUE);
        int lastIndex = searchFirstOrLastIndex(arr, i, Boolean.FALSE);
        return new int[]{firstIndex, lastIndex};
    }

    private static int searchFirstOrLastIndex(int[] arr, int target, boolean findFirst) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if(target > arr[mid]){
                start = mid + 1;
            }else if(target == arr[mid]){
                // mid might be the start index. Find first index is different from find last index in the sense that
                // if the target number is found, we look to the left in hope that the mid element is not the first one.
                // in case of find last, we look to right, to find the last most element.
                if(findFirst){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }
                ans = mid;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
