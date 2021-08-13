package leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *  
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution75 {
    public static void main(String[] args){
        new Solution75().sortColors(new int[]{2,0,2,1,1,0});
        new Solution75().sortColors(new int[]{1,0,2});
        new Solution75().sortColors(new int[]{2,0,1});
    }

    public void sortColors(int[] nums) {
        int r = 0;
        int l = nums.length - 1;
        int i = 0;
        while (i <= l){
            if (nums[i] == 0){
                swap(nums, i, r++);
                i++;
            }else if (nums[i] == 2){
                swap(nums, i, l--);
            }else {
                i++;
            }
        }
        System.out.println(Collections.singletonList(nums));
    }
    public void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }
}
