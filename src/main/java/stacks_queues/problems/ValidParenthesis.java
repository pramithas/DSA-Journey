package stacks_queues.problems;

import java.util.Stack;

public class ValidParenthesis {
    private static Stack<Character> strStack = new Stack<>();

    public static boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (strStack.isEmpty()) {
                strStack.push(s.charAt(i));
                continue;
            }

            char currChar = s.charAt(i);

            if (currChar == '{' || currChar == '(' || currChar == '[') {
                strStack.push(currChar);
            } else {
                if (currChar == '}') {
                    if (strStack.pop() != '{') {
                        return false;
                    }

                } else if (currChar == ']') {
                    if (strStack.pop() != '[') {
                        return false;
                    }

                } else if (currChar == ')') {
                    if (strStack.pop() != '(') {
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
