package leetCode;

public class Solution29 {
    public static void main(String[] args){
       new Solution29().divide(100,-3);
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
