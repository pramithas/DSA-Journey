package search.binarysearch.problems.leetcode;

public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c'};
        System.out.println(findCeil(arr, 'c'));
    }

    // my first approach.
//    static char findCeil(char[] arr, char target) {
//        int start = 0;
//        int end = arr.length - 1;
//        int ans = -1;
//
//        if(arr[arr.length-1] < target){
//            return (char)-1;
//        }
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] == target) {
//                return arr[(mid + 1) % arr.length];
//            } else if (arr[mid] < target) {
//                start = mid + 1;
//            } else if (arr[mid] > target) {
//                end = mid - 1;
//                ans = mid;
//            }
//        }
//        return arr[ans % arr.length];
//    }

    // better approach.
    static char findCeil(char[] arr, char target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // This works and is dependent on the sequence of checks.
           if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            // This does not work
//            if (arr[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
        }
        return arr[start % arr.length];
    }
}
