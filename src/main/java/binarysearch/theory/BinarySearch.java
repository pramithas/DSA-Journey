package binarysearch.theory;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {8};
        System.out.println(binarySearch(arr, 8));
    }

   public  static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

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
