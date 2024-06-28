package slidingwindow;

public class MaximumOfSubArrays {

    private static int findMaxSubArrays(int[] arr, int k) {

        // first point i an j both to 0
        int i = 0, j = 0;
        int sum = 0;

        while (j - i + 1 <= k) {
            sum += arr[j];
            j++;
        }

        int maxSum = sum;

        for (; j < arr.length; j++) {
            int sum1 = (sum - arr[i]) + arr[j];
            if(maxSum < sum1){
                maxSum = sum1;
            }
            sum = sum1;
            i++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(findMaxSubArrays(a, 3));
    }
}
