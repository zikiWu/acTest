package offer;

import java.util.*;

public class Solution27 {
    public static void main(String[] args){
        new Solution27().Permutation("abca");
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.equals(""))
            return list;
        PermutationSub(str.toCharArray(),list,"",0);
        Collections.sort(list);
        return list;
    }
    public void PermutationSub(char[] str,ArrayList<String> list,String s,int i) {
        if (i == str.length){
            list.add(s);
            System.out.println(s);
        }
        Map<Character,Integer> map = new HashMap();
        for (int j = i; j < str.length; j++) {
            if (map.containsKey(str[j])){
                continue;
            }
            map.put(str[j],j);
            swap(str,i,j);
            PermutationSub(str,list,s+str[i],i+1);
            swap(str,i,j);
        }
    }
    public static void swap(char[] nums,int j,int i) {
        if (i == j)
            return;
        char tamp = nums[i];
        nums[i] = nums[j];
        nums[j] = tamp;
    }


}
