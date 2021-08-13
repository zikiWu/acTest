package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */

public class Solution14 {
    public static void main(String[] args) {
        String s = new Solution14().longestCommonPrefix(new String[]{"flower","flower","flower","flower"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1){
            return strs[0];
        }
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while (true){
            boolean b = true;
            for (int i = 0;i < strs.length - 1; i++){
                if (strs[i].length() <= n || strs[i+1].length() <= n || strs[i].charAt(n) != strs[i+1].charAt(n)){
                    b = false;
                    break;
                }
            }
            if (!b){
                return sb.toString();
            }
            sb.append(strs[0].charAt(n++));
        }

    }
}
