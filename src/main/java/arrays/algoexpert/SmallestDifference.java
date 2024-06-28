package arrays.algoexpert;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int result[] = new int[2];
        int firstPointer = 0;
        int secondPointer = 0;
        int smallest = Integer.MAX_VALUE;
        // When an element of a certain array is bigger, there is no need to move to the next element.
        // Just move to the next element of the array for the smaller number.
        while(firstPointer < arrayOne.length && secondPointer < arrayTwo.length){
            if(arrayOne[firstPointer] == arrayTwo[secondPointer]){
                result[0] = arrayOne[firstPointer];
                result[1] = arrayTwo[secondPointer];
                break;
            }else if(arrayOne[firstPointer] < arrayTwo[secondPointer]){
                int diff = arrayTwo[secondPointer] - arrayOne[firstPointer];
                if(diff < smallest){
                    smallest = diff;
                    result[0] = arrayOne[firstPointer];
                    result[1] = arrayTwo[secondPointer];
                }
                firstPointer++;
            }else{
                int diff = arrayOne[firstPointer] - arrayTwo[secondPointer];
                if(diff < smallest){
                    smallest = diff;
                    result[0] = arrayOne[firstPointer];
                    result[1] = arrayTwo[secondPointer];
                }
                secondPointer++;
            }
        }

        return result;
    }
}
