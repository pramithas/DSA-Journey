package arrays.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

    public static List<Integer> missingNumbers(int[] nums) {

        List<Integer> idealArr = new ArrayList<>();

        for(int i = 0; i < nums.length + 2; i++){
            idealArr.add(i + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            if(idealArr.contains(num)){
                idealArr.remove(idealArr.indexOf(num));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int input[] = {1,2};
        missingNumbers(input);
    }

}

