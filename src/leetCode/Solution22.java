package leetCode;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public static void main(String[] args){
        List<String> list = new Solution22().generateParenthesis3(3);
        list.forEach(System.out::println);
    }

    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<>();
        parenthesis3(n,n,"",list);
        return list;
    }

    public void parenthesis3(int n, int m, String s ,List<String> list){
        if (n == 0 && m == 0){
            list.add(s);
            return;
        }
        if (n > 0){
            parenthesis3(n - 1, m, s + "(", list);
        }
        if (n < m){
            parenthesis3(n, m - 1, s + ")", list);
        }
    }




    public List<String> generateParenthesis2(int n) {
        List<String> ss = new ArrayList<>();
        parenthesis(n, 0, n, "", ss);
        return ss;
    }

    public void parenthesis(int n, int i, int j, String s, List<String> ss) {
        if (n == 0 && j == 0){
            ss.add(s);
            return;
        }

        if (n == 0){
            parenthesis(n, i - 1, j - 1, s+")", ss);
        } else if (i == 0){
            parenthesis(n - 1, i + 1, j , s+"(", ss);
        }else {
            parenthesis(n - 1, i + 1, j , s+"(", ss);
            parenthesis(n, i - 1, j - 1, s+")", ss);
        }

    }







    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n,list,"",0,0);
        return list;
    }
    public void generate(int n,List<String> list,String cur,int r,int l) {
        if (cur.length() == n*2){
            list.add(cur);
        }
        if(r<n){
            generate(n,list,cur+"(",r+1,l);
        }
        if (r>l){
            generate(n,list,cur+")",r,l+1);
        }
    }
}
