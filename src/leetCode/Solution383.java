package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *383. 赎金信
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class Solution383 {
    public static void main(String[] args){

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++){
            Integer num = map.get(magazine.charAt(i));
            map.put(magazine.charAt(i), num != null ? num + 1 : 1);
        }
        for (int i = 0; i < ransomNote.length(); i++){
            Integer num = map.get(ransomNote.charAt(i));
            if (num == null || num == 0){
                return false;
            }
            map.put(ransomNote.charAt(i), num - 1);
        }
        return true;
    }
}
