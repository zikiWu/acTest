package leetCode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution128 {
    public static void main(String[] args){
        new Solution128().longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums){
            hs.add(i);
        }
        int max = 0;
        for (Integer cur : hs) {
            if (!hs.contains(cur - 1)) {
                int curMax = 1;
                while (hs.contains(cur + 1)) {
                    curMax++;
                    cur++;
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
}
