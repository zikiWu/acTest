package leetCode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution4 {
    public static void main(String[] args){

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n<m){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums1[j-1] > nums2[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums2[i-1] > nums1[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums1[j-1]; }
                else if (j == 0) { maxLeft = nums2[i-1]; }
                else { maxLeft = Math.max(nums2[i-1], nums1[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums1[j]; }
                else if (j == n) { minRight = nums2[i]; }
                else { minRight = Math.min(nums1[j], nums2[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }




    public int find2(int[] nums1, int x){
        int low = 0;
        int high = nums1.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums1[mid] == x){
                return mid;
            }else if (nums1[mid] > x){
                high = mid - 1;
            }else if (nums1[mid] < x){
                low = mid + 1;
            }
        }
        return -1;
    }
}
