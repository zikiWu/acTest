package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 */
public class Solution39 {
    public static void main(String[] args){
//        new Solution39().combinationSum(new int[]{3,12,9,11,6,7,8,5,4},15);
        System.out.println(new Solution39().combinationSum2(new int[]{3,12,9,11,6,7,8,5,4},15));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sum2(candidates, target, 0, new LinkedList<>(), result, 0);
        return result;
    }

    public void sum2(int[] candidates, int target, int sum, LinkedList<Integer> sumList, List<List<Integer>> result, int i) {
        if (sum > target){
            return;
        }
        if (sum == target){
            result.add(new ArrayList<>(sumList));
            return;
        }
        for (; i < candidates.length; i++){
            sumList.addLast(candidates[i]);
            sum2(candidates, target, sum + candidates[i], sumList, result, i);
            sumList.removeLast();
        }
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        combination(candidates,target,lists,"",0);
        return lists;
    }
    public void combination(int[] candidates, int target,List<List<Integer>> lists,String s,int i) {
        System.out.println(target+" "+i+" "+s);
        if (target<0 || i >=candidates.length){
            return;
        }
        if (target == 0){
            System.out.println(s);
            List<Integer> list = new ArrayList<>();
            String[]  ss = s.split(",");
            for (int j = 1; j < ss.length; j++) {

                list.add(Integer.parseInt(ss[j]));
            }
            lists.add(list);
            return ;
        }
        combination(candidates,target-candidates[i],lists,s+","+candidates[i],i);
        combination(candidates,target,lists,s,i+1);
    }
}
