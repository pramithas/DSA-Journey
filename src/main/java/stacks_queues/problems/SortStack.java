package stacks_queues.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public static ArrayList<Integer> sortStack(List<Integer> stack) {

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer num: stack) {

            if(result.isEmpty()){
                result.add(num);
                continue;
            }
            List<Integer> tempList = new ArrayList<>();
            while (!result.isEmpty() && num < result.getLast()){
                tempList.add(result.removeLast());
            }
            result.add(num);

            for (int i = tempList.size() - 1; i >=0 ; i--) {
                result.add(tempList.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(-5, 2, -2, 4, 3, 1);
        sortStack(myList);
    }
}
