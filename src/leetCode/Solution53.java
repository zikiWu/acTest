package leetCode;


import java.util.LinkedList;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 */
public class Solution53 {
    public static void main(String[] args){
        new Solution53().maxSubArray(new int[]{1});
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums){
            curSum+=num;
            max = Math.max(curSum, max);
            // 重新开始
            if (curSum <= 0){
                curSum = 0;
            }
        }
        return max;
    }
    // 动态规划
    public int maxSubArray2(int[] nums) {
        int[] nn = new int[nums.length];
        nn[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            nn[i] = Math.max(nn[i - 1] + nums[i], nums[i]);
            if (max < nn[i]){
                max = nn[i];
            }
        }
        return max;
    }

    // 动态规划
    public int maxSubArray3(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (sum > 0){
                sum+=nums[i];
            }else {
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}
