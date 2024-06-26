package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 简单
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class Solution205 {
    public static void main(String[] args){

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Character> imap = new HashMap<>();
        Map<Character, Character> jmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = imap.get(s.charAt(i));
            if (c == null){
                if (jmap.containsKey(t.charAt(i))){
                    return false;
                }
                imap.put(s.charAt(i), t.charAt(i));
            }else if (c != t.charAt(i)){
                return false;
            }
            jmap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
