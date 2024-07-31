package leetCode;

/**
 * 67. 二进制求和
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
public class Solution67 {
    public static void main(String[] args){
        System.out.println(new Solution67().addBinary("11", "1"));
        System.out.println(new Solution67().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int ia = ca.length - 1;
        int ib = cb.length - 1;
        String re = "";
        int add = 0;
        while (ia >= 0 || ib >= 0){
            int sum = 0;
            if (ia >= 0){
                sum += ca[ia--] - '0';
            }
            if (ib >= 0){
                sum += cb[ib--] - '0';
            }
            sum += add;
           re = (sum % 2) + re;
           add = sum >= 2 ? 1 : 0;
        }
        if (add > 0){
            re = 1 + re;
        }
        return re;
    }

}
