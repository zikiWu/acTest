package leetCode;


/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */


public class Solution29 {
    public static void main(String[] args){

        System.out.println(-1 << 1);
       new Solution29().divide(100,-3);
    }

    public int divide2(int dividend, int divisor) {
        boolean if1 = true;
        boolean if2 = true;
        if (if1 = dividend < 0){
            dividend = -divisor;
        }
        if (if2 = divisor < 0){
            divisor = -divisor;
        }
        return 0;
    }
















    //解题思路：20/3 === (3x2^2 + 3x2^1)
    public int divide(int dividend, int divisor) {
        boolean isF1;
        boolean isF2;
        if (isF1 = dividend > 0){
            dividend = -dividend;
        }
        if (isF2 = divisor > 0){
            divisor = -divisor;
        }
        int n = 0;
        while (dividend <= divisor){
            int temp = divisor;
            int res_temp = -1;
            while (dividend <= temp<<1 && temp > Integer.MIN_VALUE >>1 ){
               temp = temp << 1;
               res_temp = res_temp <<1;
            }
            dividend -= temp;
            n += res_temp;
        }
        if ((isF1 && isF2)||(!isF1 && !isF2)){
            n = n == Integer.MIN_VALUE?-(n+1):-n;
        }
        System.out.println(n);
        return n;
    }
}
