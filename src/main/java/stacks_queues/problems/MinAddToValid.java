package stacks_queues.problems;

import java.util.Stack;

public class MinAddToValid {

    /**
     * If present element in the queue is ( and you have ) in the input pop, the bracket. Otherwise,
     * just push it. And, at last return the size of the array.
     * @param s
     * @return
     */
    public static int minAddToMakeValid(String s) {

        Stack<Character> strStack = new Stack<>();

        for (char currChar : s.toCharArray()) {

            if (currChar == '(') {
                strStack.push(currChar);
            } else {
                if (currChar == ')') {
                    if (!strStack.isEmpty() && strStack.peek() == '(') {
                        strStack.pop();
                    } else {
                        strStack.push(currChar);
                    }
                }
            }
        }
        return strStack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())))"));
    }
}
