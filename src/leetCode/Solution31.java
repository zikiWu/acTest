package leetCode;

import java.util.ArrayList;

public class Solution31 {
    public static void main(String[] args){
        int[] a = new int[]{3,2,1,0};
        new Solution31().nextPermutation(a);
        System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]);

        int[] a2 = new int[]{1,5,1};
        new Solution31().nextPermutation(a2);
        System.out.println(a2[0]+" "+a2[1]+" "+a2[2]);
    }
    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while (j>=0 && nums[j] >= nums[j+1]){
            j--;
        }
        //最长子序列逆序
        for (int k1 = j+1,k2 = nums.length-1;k1<k2;k1++,k2--){
            swap(nums,k1,k2);
        }
        //最长子序列中的比j大的最小值 与 j交换位置
        if (j<0){
            return;
        }
         for (int i = j+1; i< nums.length; i++){
             if (nums[i] > nums[j]){
                 swap(nums,i,j);
                 return;
             }
         }
    }
    public void swap(int[] nums,int j,int i) {
        if (i == j)
            return;
        int tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }
}
