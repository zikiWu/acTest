package offer;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Solution88 {
    public static void main(String[] args){
        new Solution88().merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        new Solution88().merge(new int[]{2,0},1,new int[]{1},1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m+n];
        int nn = 0;
        int n1 = 0;
        int n2 = 0;
        while (n1 < m && n2 < n){
            if (nums1[n1] < nums2[n2]){
                sort[nn++] = nums1[n1++];
            }else {
                sort[nn++] = nums2[n2++];
            }
        }
        while (n1 < m){
            sort[nn++] = nums1[n1++];
        }
        while (n2 < n){
            sort[nn++] = nums2[n2++];
        }
        for (int i = 0 ; i < m+n; i++){
            nums1[i] = sort[i];
        }
        System.out.println(nums1);
    }
}
