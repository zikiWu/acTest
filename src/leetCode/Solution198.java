package leetCode;

/**
 * 198. 打家劫舍
 * 中等
 * 相关标签
 * 相关企业
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class Solution198 {
    public static void main(String[] args){
        System.out.println(new Solution198().rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        if (nums.length <= 1){
            return nums[0];
        }
        if (nums.length <= 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] a = new int[nums.length];
        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            if (i - 3 < 0){
                a[i] = nums[i] + a[i - 2];
            }else {
                a[i] = nums[i] + Math.max(a[i - 2], a[i - 3]);
            }
        }
        return Math.max(a[nums.length - 1], a[nums.length - 2]);
    }


    public int rob2(int[] nums) {
        if (nums.length <= 1){
            return nums[0];
        }
        if (nums.length <= 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] a = new int[nums.length];
        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
        }
        return a[nums.length - 1];
    }
}
