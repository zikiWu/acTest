package leetCode;

/**
 * 242. 有效的字母异位词
 * 简单
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 */
public class Solution242 {
    public static void main(String[] args){

    }

    public boolean isAnagram(String s, String t) {
        int[] ii = new int[26];
        int[] jj = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            ii[s.charAt(i)-'a'] += 1;
            jj[t.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < 26; i++){
            if (ii[i] != jj[i]){
                return false;
            }
        }
        return true;
    }

}
