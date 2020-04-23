package leetCode;

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
}
