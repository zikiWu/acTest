package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {
    public static void main(String[] args){
        new Solution3().lengthOfLongestSubstring("abbcabcbb");
    }
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> l = new LinkedList<>();
        int maxLen = 0;
        for (int i = 0; i<s.length();i++){
            while (l.contains(s.charAt(i))){
                l.removeFirst();
            }
            l.addLast(s.charAt(i));
            maxLen = Math.max(l.size(), maxLen);
        }
        return maxLen;
    }

}
