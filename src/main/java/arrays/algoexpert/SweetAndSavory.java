package arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SweetAndSavory {

    public static int[] sweetAndSavory(int[] dishes, int target) {

        List<Integer> sweet = new ArrayList<>();
        List<Integer> savory = new ArrayList<>();

        for (int num : dishes) {
            if (num < 0) {
                sweet.add(num);
            } else {
                savory.add(num);
            }
        }

        sweet.sort(Collections.reverseOrder());
        Collections.sort(savory);

        int leftPointer = 0;
        int rightPointer = 0;
        int sum = Integer.MIN_VALUE;
        int[] result = new int[2];

        while (leftPointer < sweet.size() && rightPointer < savory.size()) {

            int tempSum = sweet.get(leftPointer) + savory.get(rightPointer);

            if (tempSum <= target) {


                if (tempSum > sum) {
                    result[0] = sweet.get(leftPointer);
                    result[1] = savory.get(rightPointer);
                    sum = tempSum;
                }

                if (tempSum == target) {
                    return new int[]{sweet.get(leftPointer), savory.get(rightPointer)};
                }

                rightPointer++;

            } else {
                leftPointer++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-12, 13, 100, -53, 540, -538, 53, 76, 32, -63};
        System.out.println(Arrays.toString(sweetAndSavory(array, 42)));
    }
}
