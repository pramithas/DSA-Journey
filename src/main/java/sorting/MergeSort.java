package sorting;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] array, int start, int end){

        if(start == end) return new int[] {array[start]};

        int mid = start + (end - start) / 2;

        int[] left = mergeSort(array, start, mid);
        int[] right = mergeSort(array, mid+1, end);

        int[] finalArray = new int[left.length + right.length];

        int leftStart = 0;
        int rightStart = 0;
        int idx = 0;

        while(leftStart < left.length && rightStart < right.length){
            if(left[leftStart] <= right[rightStart]){
                finalArray[idx++] = left[leftStart];
                leftStart++;
            }else{
                finalArray[idx++] = right[rightStart];
                rightStart++;
            }
        }

        while(leftStart < left.length){
            finalArray[idx++] = left[leftStart];
            leftStart++;
        }

        while(rightStart < right.length){
            finalArray[idx++] = right[rightStart];
            rightStart++;
        }

        return finalArray;

    }

    public static void main(String[] args) {
        int[] array = {2, 1};
        mergeSort(array);
    }
}
