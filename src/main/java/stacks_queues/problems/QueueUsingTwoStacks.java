package stacks_queues.problems;

import java.util.Stack;

public class QueueUsingTwoStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int popped = stack2.pop();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return popped;
    }

    public int peek() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int peeked = stack2.peek();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }

        return peeked;
    }

    public boolean empty() {
        return stack1.empty();
    }
}

/**
 * Your QueueUsingTwoStacks object will be instantiated and called as such:
 * QueueUsingTwoStacks obj = new QueueUsingTwoStacks();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */