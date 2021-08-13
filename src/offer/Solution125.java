package offer;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class Solution125 {
    public static void main(String[] args){
        new Solution125().isPalindrome("race a car");
        new Solution125().isPalindrome("A man, a plan, a canal: Panama");
        new Solution125().isPalindrome("0P");
    }
    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j){
            while (!(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z'  || s.charAt(i)>='0' && s.charAt(i)<='9' ) && j > i){
                i++;
            }
            while (!(s.charAt(j)>='a' && s.charAt(j)<='z' || s.charAt(j)>='A' && s.charAt(j)<='Z'  || s.charAt(j)>='0' && s.charAt(j)<='9' ) && j > i){
                j--;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
