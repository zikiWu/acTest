package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public static void main(String[] args){
        List<String> list = new Solution22().generateParenthesis(3);
        list.forEach(System.out::println);
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
