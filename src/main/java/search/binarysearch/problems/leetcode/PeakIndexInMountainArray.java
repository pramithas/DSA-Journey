package search.binarysearch.problems.leetcode;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int peak = findPeakIndex(arr);
        System.out.println(peak);
    }

    /**
     * First approach I thought of
     *
     * @param arr
     * @return
     */
//    static int findPeakIndex(int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//        int ans = -1;
//
//        while (start != end) {
//            int mid = start + (end - start) / 2;
//
////            if (mid == 0) {
////                start = mid + 1;
////            } else if (mid == arr.length - 1) {
////                end = mid - 1;
////            } else
//            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
//                return arr[mid];
//            } else if (arr[mid] > arr[mid - 1]) {
//                start = mid + 1;
//                ans = arr[mid];
//            } else if (arr[mid] < arr[mid - 1]) {
//                end = mid - 1;
//                ans = arr[mid];
//            }
//        }
//        return ans;
    //}
    static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in descending portion of the array. So, the peak might lie to left
                // why mid and not mid - 1??
                // 1 2 3 4 5 4 3
                // for example, if mid = 5, then arr[mid] > arr[mid+1]. And, 5 can still be the number, so
                // include 5. Thus, end = mid and not mid-1. But, if we are in ascending array and mid is 4 then the
                //condition satisfies: arr[mid] < arr[mid+1]. In, this case, we know for sure that 4 is not the peak.
                //So, we do start = mid + 1. Thus, for first condition, we do, end = mid but for the second, start= mid+1.
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // Here, basically start == end.
        return start;
    }

}
