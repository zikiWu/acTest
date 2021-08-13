package leetCode;

import com.sun.deploy.util.StringUtils;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 */
public class Solution28 {
    public static void main(String[] args){
        System.out.println(new Solution28().strStr("aabaaabaaac","aabaaac"));
    }
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] a = getNext(needle);
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                if (j == needle.length() - 1){
                    return i - j;
                }else {
                    i++;
                    j++;
                }
            }else if(a[j] < 0){
                i++;
            }else {
                j = a[j];
            }
        }
        return -1;
    }

    public int[] getNext(String needle){
        int[] a = new int[needle.length()];
        a[0] = -1;
        if (needle.length() == 1){
            return a;
        }
        a[1] = 0;
        if (needle.length() == 2){
            return a;
        }
        for (int i = 2; i < needle.length() ;i++){
            if (a[i - 1] == 0){
                a[i] = needle.charAt(0) == needle.charAt(i -1) ? 1 : 0;
            }else {
                a[i] = needle.charAt(a[i - 1]) == needle.charAt(i - 1) ? a[i-1] + 1:0;
            }
        }
        return a;
    }

}
