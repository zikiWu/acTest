package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution96 {
    public static void main(String[] args){

        new Solution96().numTrees(3);
    }

    public int numTrees(int n) {
        int[] a = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2;i<=n;i++){
            for (int j = 1; j <= i; j++) {
                a[i] += a[j-1]*a[i-j];
            }
        }
        System.out.println(a[n]);

        return a[n];
    }
    //回溯
    public int numTrees2(int n) {
        System.out.println(trees(0,2));
        return  trees(0,n-1);
    }
    public int trees(int l,int r) {

        if (l>=r){
            return 1;
        }
        int num = 0;
        for (int i = l; i <=r ; i++) {
            num+= trees(l,i-1)*trees(i+1,r);
        }
        return num;
    }
}
