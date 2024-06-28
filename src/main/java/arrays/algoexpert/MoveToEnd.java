package arrays.algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveToEnd {

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {
        int lastPointer = array.size() - 1;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == toMove){
                while(i < lastPointer && array.get(lastPointer) == toMove){
                    lastPointer--;
                }
                Collections.swap(array, i, lastPointer);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,1,2,2,2,3,4,2);
        int toMove = 2;
        System.out.println(moveElementToEnd(input, toMove));
    }
}
