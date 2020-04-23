package leetCode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution42 {
    public static void main(String[] args){


    }

    public int trap(int[] height) {
        int result = 0;

        LinkedList<Integer> stack = new LinkedList();
        int w = 0;
        for (int i = 0;i<height.length;i++){
            while (!stack.isEmpty() && height[stack.getLast()] < height[i]){
                int num = stack.getLast();
                stack.removeLast();
                if (stack.isEmpty()) break;
                //弹一个算一个
                int distance = i - stack.getLast() - 1;
                int bounded_height = Math.min(height[i], height[stack.getLast()]) - height[num];
                result += distance * bounded_height;
            }
            stack.addLast(i);
        }
        return result;
    }
}
