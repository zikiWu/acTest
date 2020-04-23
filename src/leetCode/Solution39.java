package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution39 {
    public static void main(String[] args){
        new Solution39().combinationSum(new int[]{3,12,9,11,6,7,8,5,4},15);
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
