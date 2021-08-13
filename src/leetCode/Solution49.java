package leetCode;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

import java.util.*;

public class Solution49 {
    public static void main(String[] args){
        new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
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
