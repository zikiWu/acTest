package offer;

public class Solution51 {
    public static void main(String[] args){
        new Solution51().multiply(new int[]{1,2,3,4,5});
    }
//    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
//    其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        int len = A.length;
        if (len == 0)
            return b;
        b[0] = 1;
        //上部分
        for (int i = 1; i < len; i++) {
            b[i] = b[i-1] * A[i-1];
        }
        //下部分
        int temp = 1;
        for (int i = len-2; i >= 0; i--) {
            temp *= A[i+1];
            b[i] *= temp;
        }
        return b;
    }
}
