package leetCode;

import java.util.LinkedList;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * Related Topics
 * 数组
 * 二分查找
 * 前缀和
 * 滑动窗口
 */
public class Solution209 {
    public static void main(String[] args){
        new Solution209().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            curSum += nums[i];
            while (curSum - nums[l] >= target){
                curSum -= nums[l++];
            }
            if (curSum >= target){
                minLen = Math.min(minLen, i - l + 1);
            }
        }
        if (minLen == Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}
