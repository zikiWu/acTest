package leetCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 */
public class Solution42 {
    public static void main(String[] args){
//       new Solution42().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
       new Solution42().trap2(new int[]{4,2,0,3,2,5});

    }



    public int trap2(int[] height) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        int sum = 0;
        for (int i = 0; i < height.length; i++){
            while (!linkedList.isEmpty() && height[linkedList.getLast()] < height[i]){
                int curI = linkedList.removeLast();
                if (!linkedList.isEmpty()){
                    int curLast = linkedList.getLast();
                    sum += (Math.min(height[curLast], height[i]) - height[curI]) * (i - curLast - 1);
                }
            }
            linkedList.addLast(i);
        }
        return sum;
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
