package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeEachSubArray {

    public static List<Integer> listOfFirstNegatives(int[] arr, int k) {

        // first point i an j both to 0
        int i = 0, j = 0;
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (j - i + 1 <= k) {
            j++;
            if(arr[j] < 0){
                negativeList.add(arr[j]);
            }
        }

        for (; j <= arr.length; j++) {

            if(j < arr.length && arr[j] < 0){
                negativeList.add(arr[j]);
            }

            if(negativeList.isEmpty()){
                result.add(0);
                continue;
            }
            result.add(negativeList.getFirst());

            if (arr[i] < 0 && negativeList.contains(arr[i])) {
                negativeList.remove((Integer) arr[i]);
            }

            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(listOfFirstNegatives(a, 3));
    }
}
