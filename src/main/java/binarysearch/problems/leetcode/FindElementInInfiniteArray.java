package binarysearch.problems.leetcode;

public class FindElementInInfiniteArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 8, 9, 16, 19, 21};
        System.out.println(findIndex(arr, 21));
    }

    static int findIndex(int[] arr, int target) {

        // This approach (commented code) check for each range whether or not the target lies in that range. And, if yes,
        //it conducts binary search in that range. We can be more concise here.
        int start = 0;
        int end = 1;
        int diff = end - start;

//        while (true){
//            if(arr[start] <= target && arr[end] >= target){
//                return search(arr, start, end, target);
//            }else {
//                start = end + 1;
//                end = start+ (diff*2);
//            }
//        }

        while (target > arr[end]) {
            start = end + 1;
            end = start + (diff * 2);
        }

        return search(arr, start, end, target);

    }

    static int search(int[] arr, int start, int end, int target) {
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

}
