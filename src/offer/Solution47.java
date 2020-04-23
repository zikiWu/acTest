package offer;

public class Solution47 {
    public static void main(String[] args){

    }
//    求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
        return ((int)(Math.pow(n, 2)+n)) >> 1;
}
    public int Sum_Solution2(int n) {
        if (n == 0)
            return 0;
        int sum = n;
        sum+=Sum_Solution2(n-1);
        return sum;
    }
}
