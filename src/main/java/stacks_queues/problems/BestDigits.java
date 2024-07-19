package stacks_queues.problems;

import java.util.Stack;

public class BestDigits {

    public static String bestDigits(String number, int numDigits) {

        Stack<Integer> helperStack = new Stack<>();

        for(char c:number.toCharArray()){

            int currentNum = c - '0';

            if(helperStack.isEmpty()){
                helperStack.push(currentNum);
                continue;
            }

            while(numDigits > 0 && !helperStack.isEmpty() && currentNum > helperStack.peek()){
                helperStack.pop();
                numDigits--;
            }
            helperStack.push(currentNum);
        }

        while(numDigits > 0){
            if(!helperStack.isEmpty()){
                helperStack.pop();
                numDigits--;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!helperStack.isEmpty()){
            result.append(helperStack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(bestDigits("988762",2));
    }
}
