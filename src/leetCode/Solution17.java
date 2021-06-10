package leetCode;


/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 输入：digits = ""
 * 输出：[]
 */


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args){
        List<String> l =  new Solution17().letterCombinations2("23");
        l.forEach(System.out::println);
    }



    public List<String> letterCombinations2(String digits) {
        List<String> l = new ArrayList<>();
        if (digits == null || digits.equals("")){
            return l;
        }
        int len = digits.length();
        String [] ss = new String[len];
        for (int i = 0 ;i < len ; i++){
            ss[i] = getABC(Integer.parseInt(digits.substring(i, i+1)));
        }
        letter(ss, 0, "", l);
        return l;
    }
    public void letter(String [] ss, int i,String s ,List<String> l) {
        if (i == ss.length){
            l.add(s);
            return;
        }
        for (int j = 0;j<ss[i].length();j++){
            letter(ss, i+1, s+ss[i].charAt(j), l);
        }
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
