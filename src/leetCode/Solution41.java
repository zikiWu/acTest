package leetCode;

/**
 *
 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。


 示例 1：

 输入：nums = [1,2,0]
 输出：3
 示例 2：

 输入：nums = [3,4,-1,1]
 输出：2
 示例 3：

 输入：nums = [7,8,9,11,12]
 输出：1
 */
public class Solution41 {
    public static void main(String[] args){
        new Solution41().firstMissingPositive2(new int[]{3,-1,2,5});
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0 ;i < nums.length; i ++){
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for (int i = 0 ;i < nums.length; i ++){
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0 ;i < nums.length; i ++){
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n+1;
    }


















    public int firstMissingPositive(int[] nums) {
        for (int i = 0;i<nums.length;i++){
            if (nums[i] >= 0){
                swap(nums,i,nums[i]-1);
                nums[nums[i]] = nums[i];
            }
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i] != i){
                System.out.println(i);
                return i;
            }
        }
        return 0;
    }
    public void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }
}
