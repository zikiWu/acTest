package leetCode;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution46 {
    public static void main(String[] args){
        System.out.println(new Solution46().permute2(new int[]{1,2,3}));

        System.out.println(new Solution46().permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        per(nums, 0, lists);
        return lists;
    }

    public void per(int[] nums,int i,List<List<Integer>> lists) {
        if (i == nums.length - 1){
            List<Integer> l = new ArrayList<>();
            for (int n : nums){
                l.add(n);
            }
            lists.add(l);
        }
        for (int k = i; k < nums.length; k++){
            swap(nums, i, k);
            per(nums, i + 1, lists);
            swap(nums, i, k);
        }
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
