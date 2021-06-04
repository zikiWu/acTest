package leetCode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 输入：x = 123
 * 输出：321
 */
public class Solution7 {
    public static void main(String[] args){
        System.out.println(new Solution7().reverse2(-123));;
    }

    public int reverse(int x) {

        int z = 1;
        if (x < 0){
            z = -1;
        }
       String s = Math.abs(x)+"";
       String s2 = "";
       for (int i = s.length() - 1 ; i>= 0 ;i--){
           s2 += s.charAt(i);
       }
       try {
           return Integer.parseInt(s2) * z;
       }catch (Exception e){
           return 0;
       }
    }

    public int reverse2(int x) {

        int r = 0;
        while (x != 0){
            if (r > Integer.MAX_VALUE /10 || r < Integer.MIN_VALUE / 10){
                return 0;
            }
            r = r * 10 + x%10;
            x = x /10;
        }
        return r;
    }
}
