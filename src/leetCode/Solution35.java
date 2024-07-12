package leetCode;

public class Solution35 {
    public static void main(String[] args){
        System.out.println(new Solution35().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new Solution35().searchInsert(new int[]{1,3,5,6}, 7));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (midNum == target){
                return mid;
            }else if (midNum > target){
                right = mid;
            }else if (midNum < target){
                left = mid + 1;
            }
        }
        return  nums[left] >= target ? left : left + 1;
    }
}
