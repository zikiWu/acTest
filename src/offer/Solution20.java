package offer;

import java.util.Stack;

public class Solution20 {
    public static void main(String[] args){

    }
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty())
            min = node;
        else
            min = Math.min(stack2.peek(),node);
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return  stack2.peek();
    }
}
