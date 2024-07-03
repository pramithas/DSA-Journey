package arrays.algoexpert;

public class BestSeat {

    public static int bestSeat(int[] seats) {

        int longestSeq = 0;
        int seqStart = -1;
        int seqEnd = -1;

        for(int i = 0; i < seats.length; i++){

            int secondPointer = i;

            while(seats[secondPointer] == 0){
                secondPointer++;
            }

            if(longestSeq < (secondPointer - i)){
                longestSeq = (secondPointer - i);
                seqStart = i;
                seqEnd = secondPointer;
            }
        }
        int result = (seqStart + (seqEnd - seqStart)/2);

        if((seqEnd - seqStart) % 2 == 0) {
            result--;
        }

        return longestSeq == 0 ? -1 : result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1};
        System.out.println(bestSeat(arr));
    }
}
