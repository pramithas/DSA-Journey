package stacks_queues.problems;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {

        final Stack<Character> strStack = new Stack<>();

        for (char currChar : s.toCharArray()) {

            if (currChar == '{' || currChar == '(' || currChar == '[') {
                strStack.push(currChar);
            } else {
                if (currChar == '}') {
                    if (strStack.isEmpty() || strStack.pop() != '{') {
                        return false;
                    }

                } else if (currChar == ']') {
                    if (strStack.isEmpty() || strStack.pop() != '[') {
                        return false;
                    }

                } else if (currChar == ')') {
                    if (strStack.isEmpty() || strStack.pop() != '(') {
                        return false;
                    }

                }
            }
        }
        return strStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
