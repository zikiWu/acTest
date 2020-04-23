package leetCode;

public class Solution26 {
    public static void main(String[] args){

        int[] nums = {};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println((nums[i]));
        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int len = 1;
        for (int i = 1; i<nums.length;i++){
            if (nums[i] > min){
                min = nums[i];
                swap(nums,len,i);
                len++;
            }
        }
        return len;
    }
    public static void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }

}
