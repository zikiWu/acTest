package offer;

import java.util.Stack;

public class Solution21 {
    public static void main(String[] args){

    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        int j = 0;
        stack.push(pushA[0]);
        while (j < popA.length ){
            while (stack.peek() != popA[j] && i < pushA.length)
                stack.push(pushA[i++]);
            if (stack.peek() == popA[j])
                stack.pop();
            j++;
        }
        return stack.isEmpty();
    }
}
