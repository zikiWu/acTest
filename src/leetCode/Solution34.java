package leetCode;


/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Solution34 {
    public static void main(String[] args){
        new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 8);
        new Solution34().searchRange(new int[]{1}, 1);
    }

    public int[] searchRange(int[] nums, int target) {
        int r = 0, l = nums.length - 1;
        int index = -1;
        while (r <= l){
            int mid = (r + l) /2;
            if (nums[mid] == target){
                index = mid;
                break;
            }
            if (target <= nums[mid]){
                l = mid - 1;
            }else {
                r = mid + 1;
            }
        }
        if (index == -1){
            return new int[]{-1, -1};
        }
        int rr = index,ll = index;
        while (rr - 1 >= 0 && nums[rr] == nums[rr-1])
            rr--;
        while (ll + 1 < nums.length && nums[ll] == nums[ll+1])
            ll++;
        return new int[]{rr , ll};
    }
}
