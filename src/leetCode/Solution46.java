package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution46 {
    public static void main(String[] args){
        System.out.println(new Solution46().permute(new int[]{1,2,3,4}));

        System.out.println(new Solution46().permuteUnique(new int[]{1,1,2}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        per(nums,lists,0);
        return lists;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        per2(nums,lists,0);
        return lists;
    }
    //不重复
    public void per2(int[] nums,List<List<Integer>> lists,int i) {
        if (i == nums.length){

            List<Integer> l = new ArrayList<>();
            for (int n = 0;n<i;n++){
                l.add(nums[n]);
                System.out.print(nums[n]);
            }
            System.out.println();
            lists.add(l);
            return;
        }
        Map<Integer,Integer> map = new HashMap();
        for (int j = i;j < nums.length; j++){
            if (map.containsKey(nums[j])){
                continue;
            }
            map.put(nums[j],j);
            swap(nums,j,i);
            per2(nums,lists,i+1);
            swap(nums,j,i);
        }
    }
    //重复
    public void per(int[] nums,List<List<Integer>> lists,int i) {
        if (i == nums.length){

            List<Integer> l = new ArrayList<>();
            for (int n = 0;n<i;n++){
                l.add(nums[n]);
                System.out.print(nums[n]);
            }
            System.out.println();
            lists.add(l);
            return;
        }
        for (int j = i;j < nums.length; j++){
            swap(nums,j,i);
            per(nums,lists,i+1);
            swap(nums,j,i);
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
