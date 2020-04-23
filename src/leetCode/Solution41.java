package leetCode;

public class Solution41 {
    public static void main(String[] args){
        new Solution41().firstMissingPositive(new int[]{3,-1,2,5});
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
