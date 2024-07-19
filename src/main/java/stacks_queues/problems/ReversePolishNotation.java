package stacks_queues.problems;

import java.util.Stack;

public class ReversePolishNotation {
    public static int reversePolishNotation(String[] tokens) {

        Stack<String> myStack = new Stack<>();

        for (String str : tokens) {

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {

                int firstOp = Integer.parseInt(myStack.pop());
                int secondOp = Integer.parseInt(myStack.pop());

                switch (str) {
                    case "+":
                        myStack.push(String.valueOf(firstOp + secondOp));
                        break;
                    case "-":
                        myStack.push(String.valueOf(secondOp - firstOp));
                        break;
                    case "*":
                        myStack.push(String.valueOf(firstOp * secondOp));
                        break;
                    case "/":
                        myStack.push(String.valueOf(secondOp / firstOp));
                        break;
                }
            }else {
                myStack.push(str);
            }
        }
        return Integer.parseInt(myStack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"50","3","17","+","2","-","/"};
        System.out.println(reversePolishNotation(tokens));
    }
}
