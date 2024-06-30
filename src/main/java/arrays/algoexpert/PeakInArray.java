package arrays.algoexpert;

public class PeakInArray {

    public static int longestPeak(int[] array) {

        if (array.length == 1 || array.length == 0) {
            return 0;
        }

        int firstPointer = 0;
        int secondPointer = 1;
        int longestPeak = 0;
        boolean secondcoderan =false;

        while (secondPointer < array.length - 1) {

            if(array[firstPointer] > array[secondPointer]){
                firstPointer++;
                secondPointer++;
                continue;
            }

            if(array[firstPointer] < array[secondPointer]){
                while (secondPointer < array.length - 1 && array[secondPointer] < array[secondPointer + 1]){
                    secondPointer++;
                }
            }

            if(secondPointer < array.length - 1 && array[secondPointer] > array[secondPointer + 1]){
                secondcoderan = true;
                secondPointer++;
            }else {
                firstPointer = secondPointer;
                secondPointer++;
            }

            if(secondcoderan && longestPeak < (secondPointer - firstPointer)){
                longestPeak = (secondPointer - firstPointer) + 1;
            }
        }
        return longestPeak;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 2, 10, 12};
        System.out.println(longestPeak(array));
    }
}
