package recursion.mergesort;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeSort {
    static int[] mergeSort(int arr[]){

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int left[] = mergeSort(Arrays.copyOfRange(arr, 0 , mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

        int result[] = new int[left.length+ right.length];

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                result[k] = left[i];
                i++;
            }else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length){
            result[k] = right[j];
            k++;
            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        Map<String, String> blockValues = new HashMap<>();
        blockValues.put("status_block_EPOCH","hello");
        List<String> keys = blockValues.keySet().stream().filter(s -> s.startsWith("status_block")).collect(Collectors.toList());
        System.out.println(blockValues.get("asdf"));

    }


}
