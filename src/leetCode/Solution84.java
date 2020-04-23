package leetCode;

import java.util.Stack;

public class Solution84 {
    public static void main(String[] args){

//        new Solution84().largestRectangleArea(new int[]{2,1,5,6,2,3});

//        new Solution84().largestRectangleArea(new int[]{6, 7, 5, 2, 4, 5, 9, 3});
        ThreadLocal<String> local = ThreadLocal.withInitial(()->"5");
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        int len = heights.length;
        for (int i = 0;i<len;i++){
            while (stack.peek() != -1 && heights[i]<=heights[stack.peek()]){
                int n = stack.pop();
                max = Math.max(heights[n]*(i-stack.peek()-1),max);
            }
            stack.push(i);
        }
        System.out.println(max);
        while (stack.peek() != -1){
            int n = stack.pop();
            max = Math.max(heights[n]*(len-stack.peek()-1),max);
        }
        System.out.println(max);
        return max;
    }
}
