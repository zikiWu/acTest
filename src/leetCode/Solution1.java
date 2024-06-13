package leetCode;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution1 {
    public static void main(String[] args){
        new Solution1().twoSum(new int[]{3,2,4}, 6);
        int[] ints = new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints[0] + " " + ints[1]);
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entrie : entries){
            if (map.get(target - entrie.getKey()) != null){
                if (!Objects.equals(entrie.getValue(), map.get(target - entrie.getKey()))){
                    return new int[]{entrie.getValue(), map.get(target - entrie.getKey())};
                }
            }
        }
        return null;
    }







//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i<nums.length;i++){
//            if (map.containsKey(nums[i])){
//                return new int[]{map.get(i), i};
//            }
//            map.put(target - nums[i], i);
//        }
//        return new int[]{-1, -1};
//    }
}
