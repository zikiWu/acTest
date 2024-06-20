package leetCode;

/**
 * 49. 字母异位词分组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */

import java.util.*;

public class Solution49 {
    public static void main(String[] args){
        new Solution49().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    /**
     * 通过26个字母顺序，来组成 字母_数 独一的map key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String s:strs){
            int[] ii = new int[26];
            for (int i = 0; i < s.length(); i++){
                ii[s.charAt(i) - 'a'] += 1;
            }
            String key = "";
            for (int i = 0; i < 26; i++){
                if (ii[i] != 0){
                    key += i + "_" + ii[i];
                }
            }
            if (strMap.containsKey(key)){
                List<String> stringList = strMap.get(key);
                stringList.add(s);
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                strMap.put(key, stringList);
            }
        }
        return new ArrayList<>(strMap.values());
    }







    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String s:strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sortStr = "";
            for (char c : cs){
                sortStr += c;
            }
            if (strMap.containsKey(sortStr)){
                strMap.get(sortStr).add(s);
            }else {
                List<String> l = new ArrayList<>();
                l.add(s);
                strMap.put(sortStr, l);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> m : strMap.entrySet()) {
            resultList.add(m.getValue());
        }
        return resultList;
    }

}
