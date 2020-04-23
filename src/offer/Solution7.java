package offer;

public class Solution7 {
    public static void main(String[] args){

    }
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n < 3)
            return 1;
        int i1 = 1;
        int i2 = 1;
        int num = 1;
        for (int i = 3; i <= n; i++) {
            num = i1+i2;
            i1 = i2;
            i2 = num;
        }
        return num;
    }
}
