package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class Solution139 {
    public static void main(String[] args){
        new Solution139().wordBreak("leetcode",Arrays.asList("leet","code"));
    }

    /**
     *  leetcode
     * 100010001
     * 从i=0开始，往前j组成单词去list匹配。匹配到了说明当前[j-i]是能拆分了。然后再看j-1 是不是也是能拆分的，那当前i就是能拆分的。
     * 即使用了前dp[j]的结果来实现动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j >= 0; j--){
                if (wordDict.contains(s.substring(j, i + 1)) && dp[j] == 1){
                    dp[i + 1] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
