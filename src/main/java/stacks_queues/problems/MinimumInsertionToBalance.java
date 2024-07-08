package stacks_queues.problems;

import java.util.Stack;

public class MinimumInsertionToBalance {

    public int minInsertions(String s) {

        Stack<Character> strStack = new Stack<>();

        char prev = ' ';

        for (char currChar : s.toCharArray()) {

            if (currChar == '(') {
                strStack.push(currChar);
            } else {
                if (currChar == ')' && prev == ')') {
                    if (!strStack.isEmpty() && strStack.peek() == '(') {
                        strStack.pop();
                    } else {
                        strStack.push(currChar);
                    }
                }
            }
            prev = currChar;
        }
        return strStack.size();
    }
}
