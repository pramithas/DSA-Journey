package practice;

import java.util.Arrays;

public class Practice {

    public static int fact(int n){
        if(n <= 0) {
            return 1;
        }else{
            return n * fact(n-1);
        }
    }

    public static int binarySearch(int[] arr, int target) {

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {

            mid = start + ((end-start)/2);

            if(arr[mid] == target){
                return mid;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {6};
        System.out.println(binarySearch(arr, 6));
    }
}
