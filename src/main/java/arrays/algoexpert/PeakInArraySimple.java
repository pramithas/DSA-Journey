package arrays.algoexpert;

public class PeakInArraySimple {

    public static int longestPeak(int[] array) {

        if (array.length == 1 || array.length == 0) {
            return 0;
        }

        int peakLength = 0;

        for (int i = 1; i < array.length - 1; i++) {

            if(array[i-1] < array[i] && array[i] > array[i+1]){

                int leftIndex = i - 1;
                int rightIndex = i + 1;

                while (leftIndex - 1 >= 0 && array[leftIndex - 1] < array[leftIndex]){
                    leftIndex--;
                }

                while (rightIndex + 1 < array.length && array[rightIndex] > array[rightIndex + 1]){
                    rightIndex++;
                }

                if(peakLength < (rightIndex - leftIndex)){
                    peakLength = (rightIndex - leftIndex) + 1;
                }
            }
        }
        return peakLength;
    }

    public static void main(String[] args) {
        int[] array = {  1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1
};
        System.out.println(longestPeak(array));
    }
}