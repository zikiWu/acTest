package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 */
public class Solution11 {
    public static void main(String[] args){
        new Solution11().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        new Solution11().maxArea(new int[]{4,3,2,1,4});
        new Solution11().maxArea(new int[]{1,2,1});
        new Solution11().maxArea(new int[]{1,1});
    }
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j){
            max = Math.max(Math.min(height[i] , height[j]) * (j - i), max);
            if (height[i] < height[j]){
                i++;
            }else {
                j --;
            }
        }
        return max;
    }
}
