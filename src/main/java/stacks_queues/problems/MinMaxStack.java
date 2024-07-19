package stacks_queues.problems;

import java.util.Stack;

public class MinMaxStack {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public int peek() {
        // Write your code here.
        return stack.peek();
    }

    public int pop() {
        maxStack.pop();
        minStack.pop();
        return stack.pop();
    }

    public void push(Integer number) {
        // Write your code here.
        stack.push(number);

        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }

        if (maxStack.isEmpty() || number >= maxStack.peek()) {
            maxStack.push(number);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int getMin() {
        // Write your code here.
        return minStack.peek();
    }

    public int getMax() {
        // Write your code here.
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(2);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(0);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(4);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(4);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(11);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(-11);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.pop();


    }
}