package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args){
        List<String> l =  new Solution17().letterCombinations("23");
        l.forEach(System.out::println);
    }
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        if(digits.length() == 0){
            return l;
        }
        letterCombinations(l,0,digits,"");
        return l;
    }
    public void letterCombinations(List<String> l,int n ,String digits,String cur) {
        if (n == digits.length()){
            l.add(cur);
            return;
        }
        int i = Integer.parseInt(digits.charAt(n)+"");
        String s = getABC(i);
        for (int j = 0;j< s.length();j++){
            letterCombinations(l,n+1,digits,cur+s.charAt(j));
        }
    }
    public String getABC(int c) {
        String[] a = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return a[c-2];
    }
}
