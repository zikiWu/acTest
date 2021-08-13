package leetCode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 提示：

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 -104 <= xn <= 104
 */
public class Solution50 {
    public static void main(String[] args){
        new Solution50().myPow(2,-2147483648);
    }

    public double myPow(double x, int n) {
        if (x == 0 )
            return 0;
        if (n == Integer.MIN_VALUE && Math.abs(x) == 1)
            return x;
        if (n == Integer.MIN_VALUE && Math.abs(x) != 1)
            return 0;
        double num = pow(x, Math.abs(n));
        if (n < 0){
            num = 1/num;
        }
        return num;
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double num = pow(x, n / 2);
        num *= num;
        if (n % 2 == 1)
            num *= x;
        return num;
    }
}
